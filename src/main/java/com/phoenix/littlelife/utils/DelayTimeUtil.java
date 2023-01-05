package com.phoenix.littlelife.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

/**
 * @author liyangyang
 * @date 2022/12/29 13:12
 */

public class DelayTimeUtil {

    public static long delayMillis(LocalDateTime activeTime){
        return activeTime.toInstant(ZoneOffset.of("+8")).toEpochMilli()-System.currentTimeMillis();
    }


    public static Integer computeDelayLevel(LocalDateTime activate){
        long mill = TimeUnit.MILLISECONDS.toMinutes(delayMillis(activate));
        //时间开始时间与当前时间差： delayMin分钟
        int delayMin = Long.valueOf(mill).intValue();
        //1min-10min范围内每多一分钟leve+1,s级有4等级，delayMin分钟延时等级=s+delayMin
        return delayMin+4;
    }
}
