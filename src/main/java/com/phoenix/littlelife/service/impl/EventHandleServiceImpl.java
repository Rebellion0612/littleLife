package com.phoenix.littlelife.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.phoenix.littlelife.config.RocketMQProducer;
import com.phoenix.littlelife.constant.RocketConstant;
import com.phoenix.littlelife.data.param.EventPushParam;
import com.phoenix.littlelife.enums.PushType;
import com.phoenix.littlelife.repository.entity.Event;
import com.phoenix.littlelife.repository.entity.EventLog;
import com.phoenix.littlelife.repository.entity.EventUserRelation;
import com.phoenix.littlelife.repository.mapper.EventLogMapper;
import com.phoenix.littlelife.repository.mapper.EventMapper;
import com.phoenix.littlelife.repository.mapper.EventUserRelationMapper;
import com.phoenix.littlelife.service.EventHandleService;
import com.phoenix.littlelife.utils.DelayTimeUtil;
import com.phoenix.littlelife.utils.IdUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liyangyang
 * @date 2022/12/22 13:08
 */
@Component
@Slf4j
@AllArgsConstructor
@Service
public class EventHandleServiceImpl implements EventHandleService {

    private final EventLogMapper eventLogMapper;

    private final EventMapper eventMapper;

    private final EventUserRelationMapper eventUserRelationMapper;

    private final RocketMQProducer rocketMQProducer;


    /**
     * 日程推送
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void schedulePushMessage(String message) {
        EventPushParam param = JSON.parseObject(message, EventPushParam.class);
        List<EventUserRelation> relationList = eventUserRelationMapper
                .selectList(Wrappers.lambdaQuery(EventUserRelation.class)
                        .eq(EventUserRelation::getEventId, param.getEventId()));
        //todo 发送消息给前端

        //日程推送记录(正式提醒而非预约提醒)
        if (PushType.start.ordinal() == (param.getPushType())) {
            EventLog eventLog = EventLog.builder()
                    .id(IdUtils.nextId())
                    .eventId(param.getEventId())
                    .createTime(LocalDateTime.now())
                    .build();
            eventLogMapper.insert(eventLog);

            Event event = eventMapper.selectById(param.getEventId());

            //如果是周期性事件,当前日程提醒结束后 需要更改日程的开始时间,下次时间,预约提醒时间
            if (event.getEventType() == 1) {
                event.setStartTime(event.getNextTime());
                event.setNextTime(event.getStartTime().plusDays(event.getCycleDuration()));
                event.setNoticeTime(event.getStartTime().plusDays(-event.getAdvanceNoticeDays()));
                eventMapper.updateById(event);
            }
        }
    }

    @Override
    public void eventCheck() {
        // TODO: 2022/12/28 轮训要执行的时间，并发送对应的mq消息
        //查询当天需要提醒的日程
        List<Event> schedules = eventMapper.selectList(Wrappers.lambdaQuery(Event.class)
                .ge(Event::getStartTime, LocalDateTime.now().plusMinutes(2))
                .lt(Event::getStartTime, LocalDateTime.now().plusMinutes(10)));

        schedules.forEach(event -> {

            EventPushParam eventPushParam = EventPushParam.builder()
                    .eventId(event.getId())
                    .pushType(PushType.start.ordinal())
                    .build();
            Integer delayLevel = DelayTimeUtil.computeDelayLevel(event.getStartTime());
            log.info("延时等级:{},当前时间:{},目标时间:{}",delayLevel,LocalDateTime.now(),event.getStartTime());

            //发送消息提醒
            rocketMQProducer.sendDelayMsg(
                    RocketConstant.TOPIC_SCHEDULE_REMINDER,
                    null,
                    JSON.toJSONString(eventPushParam),
                    3000,
                    delayLevel);
        });


    };

}
