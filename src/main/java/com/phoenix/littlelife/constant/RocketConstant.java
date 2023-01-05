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
     * 延时等级:"1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h"
     */
    Integer DELAY_LEVEL = 14;

}
