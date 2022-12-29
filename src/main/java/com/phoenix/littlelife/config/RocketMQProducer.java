package com.phoenix.littlelife.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author liyangyang
 * @date 2022/12/28 14:50
 */
@Slf4j
@Service
public class RocketMQProducer {
    @Resource
    private RocketMQTemplate rocketMqTemplate;

    /**
     * 发生延时消息  延时等级:"1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h"
     */
    public void sendDelayMsg(String topic, String tag, String msgBody, long timeout, Integer delayLevel) {
        rocketMqTemplate.asyncSend(topic, MessageBuilder.withPayload(msgBody).build(), new SendCallback() {

            @Override
            public void onSuccess(SendResult sendResult) {
                log.info(JSON.toJSONString(sendResult));
                log.info("执行时间:" + LocalDateTime.now() + "{}-RocketMQProducer-asyncSend-success-" + topic + "-" + tag + "-" + msgBody);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        }, timeout, delayLevel);
        ;
    }


}
