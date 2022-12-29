package com.phoenix.littlelife.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author liyangyang
 * @date 2022/12/29 13:12
 */

public class GetDelayTime {
    public static long delayMillis(LocalDateTime activeTime) {
        return activeTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() - System.currentTimeMillis();
    }
}
