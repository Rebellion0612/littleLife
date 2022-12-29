package com.phoenix.littlelife.utils;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author liyangyang
 * @date 2022/12/29 13:12
 */

public class GetDelayTime {
    public static long delayMillis(LocalDateTime activeTime){
        return activeTime.toInstant(ZoneOffset.of("+8")).toEpochMilli()-System.currentTimeMillis();
    }
}
