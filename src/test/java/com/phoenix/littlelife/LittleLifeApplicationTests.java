package com.phoenix.littlelife;

import com.phoenix.littlelife.config.RocketMQProducer;
import com.phoenix.littlelife.constant.RocketConstant;
import com.phoenix.littlelife.service.impl.EventHandleServiceImpl;
import com.phoenix.littlelife.utils.GetDelayTime;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
@RequiredArgsConstructor
class LittleLifeApplicationTests {

    @Resource
    private EventHandleServiceImpl eventHandleServiceImpl;
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Resource
    private RocketMQProducer rocketMQProducer;

    private RocketConstant rocketConstant;


    @Test
    void contextLoads() {
        long mills = GetDelayTime.delayMillis(LocalDateTime.now().plusMinutes(2));
        System.out.println(mills);
    }

    @Test
    void ProducerText() {
        rocketMQTemplate.convertAndSend("Schedule_Reminder_MQ", "hello mq");
    }


    @Test
    public void testSendASyncMsg() throws JSONException {
        eventHandleServiceImpl.eventCheck();
    }


    @Test
    void testEnum() {
        rocketMQProducer.sendDelayMsg(RocketConstant.TOPIC_SCHEDULE_REMINDER, null, "test", 3000, 1);
    }


}
