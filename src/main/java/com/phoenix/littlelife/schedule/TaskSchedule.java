package com.phoenix.littlelife.schedule;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liyangyang
 * @date 2022/12/20 21:29
 */
@Component
@Slf4j
public class TaskSchedule {


    @XxlJob("testSout")
    public void testSout() {
        System.out.println(123);
    }
}
