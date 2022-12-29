package com.phoenix.littlelife.schedule;

import com.phoenix.littlelife.constant.TaskConstant;
import com.phoenix.littlelife.service.EventHandleService;
import com.phoenix.littlelife.service.impl.EventHandleServiceImpl;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liyangyang
 * @date 2022/12/28 21:29
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class EventTask {

    private final EventHandleService eventHandleService;

    @XxlJob(TaskConstant.EVENT_PUSH)
    public void eventCheck() {
        try {
            XxlJobHelper.log(TaskConstant.EVENT_PUSH.concat(" start"));
            log.info(TaskConstant.EVENT_PUSH.concat(" start"));
            eventHandleService.eventCheck();
            log.info(TaskConstant.EVENT_PUSH.concat(" end"));
            XxlJobHelper.log(TaskConstant.EVENT_PUSH.concat(" end"));
        } catch (Exception e) {
            XxlJobHelper.handleFail(TaskConstant.EVENT_PUSH.concat(" fail"));
        }
    }
}
