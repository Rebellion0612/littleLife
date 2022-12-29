package com.phoenix.littlelife.constant;

import org.springframework.stereotype.Component;

/**
 * @author liyangyang
 * @date 2022/12/28 17:15
 */
@Component
public interface RocketConstant {
    /**
     * schedule_reminder:日程推送topic
     */
    String TOPIC_SCHEDULE_REMINDER = "schedule_reminder";
    /**
     * 日程推送消费组
     */
    String GROUP_SCHEDULE_REMINDER = "group_schedule_reminder";
    /**
     * 延时等级:2h
     */
    Integer DELAY_LEVEL = 18;

}
