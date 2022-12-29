package com.phoenix.littlelife.service;

/**
 * @author liyangyang
 * @date 2022/12/28 21:34
 */
public interface EventHandleService {

    /**
     * 处理mq消息
     * @param message
     */
    void schedulePushMessage(String message);

    void eventCheck();

}
