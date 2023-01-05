package com.phoenix.littlelife.service;

import com.phoenix.littlelife.data.param.WeiChatParam;
import org.springframework.stereotype.Service;

/**
 * @author liyangyang
 * @date 2023/1/4 14:35
 */
public interface WXService {

    /**
     * 验证请求来自微信
     * @param weiChatParam
     * @return
     */
    boolean check(WeiChatParam weiChatParam);
}
