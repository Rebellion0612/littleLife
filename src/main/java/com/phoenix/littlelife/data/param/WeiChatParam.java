package com.phoenix.littlelife.data.param;

import lombok.Data;

/**
 * @author liyangyang
 * @date 2023/1/4 14:52
 */@Data
public class WeiChatParam {

    /**
     * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     */
    private String signature;
    /**
     * timestamp	时间戳
     */
    private String timestamp;
    /**
     * nonce	随机数
     */
    private String nonce;
    /**
     * echostr 随机字符串
     */
    private String echostr;


}
