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
     * 发送延时消息
     */
    public void sendDelayMsg(String topic, String tag, String msgBody, long timeout, Integer delayLevel) {
        rocketMqTemplate.asyncSend(topic, MessageBuilder.withPayload(msgBody).build(), new SendCallback() {

            @Override
            public void onSuccess(SendResult sendResult) {
                log.info(JSON.toJSONString(sendResult));
                log.info("执行时间:{}-RocketMQProducer-asyncSend-success-{}-{}-{}", LocalDateTime.now(), topic, tag, msgBody);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        }, timeout, delayLevel);
        ;
    }


}
