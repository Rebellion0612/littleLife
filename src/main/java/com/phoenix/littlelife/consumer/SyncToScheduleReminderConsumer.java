package com.phoenix.littlelife.consumer;

import com.phoenix.littlelife.constant.RocketConstant;
import com.phoenix.littlelife.service.EventHandleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liyangyang
 * @date 2022/12/28 19:49
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = RocketConstant.TOPIC_SCHEDULE_REMINDER,
consumerGroup =RocketConstant.GROUP_SCHEDULE_REMINDER
)
public class SyncToScheduleReminderConsumer implements RocketMQListener<String> {
    @Resource
    private EventHandleService eventHandleService;

    @Override
    public void onMessage(String msg) {
        try {
            //执行推送行程
            eventHandleService.schedulePushMessage(msg);
        }catch (Exception e){
            log.error(msg,e);
        }

    }
}
