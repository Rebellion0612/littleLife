package com.phoenix.littlelife;

import com.phoenix.littlelife.constant.RocketConstant;
import com.phoenix.littlelife.config.RocketMQProducer;
import com.phoenix.littlelife.service.impl.EventHandleServiceImpl;
import com.phoenix.littlelife.utils.DelayTimeUtil;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
class LittleLifeApplicationTests {

    @Resource
    private EventHandleServiceImpl eventHandleServiceImpl;
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Resource
    private RocketMQProducer rocketMQProducer;

    private RocketConstant rocketConstant;



    @Test
    void contextLoads(){
        long mills = DelayTimeUtil.delayMillis(LocalDateTime.now().plusMinutes(2));
        System.out.println(mills);
    }

    @Test
    void ProducerText() {
        rocketMQTemplate.convertAndSend("Schedule_Reminder_MQ","hello mq");
    }


    @Test
    public void testSendASyncMsg() throws JSONException {
        eventHandleServiceImpl.eventCheck();
    }


    @Test
    void testEnum(){
        String str1 = "123";
        String str2 = "asd";
        String[] str = {str1, str2};

    }



}
