package com.phoenix.littlelife.service.impl;

import com.phoenix.littlelife.data.param.WeiChatParam;
import com.phoenix.littlelife.service.WXService;
import com.phoenix.littlelife.utils.Sha1Util;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;


/**
 * @author liyangyang
 * @date 2023/1/4 14:57
 */
@Slf4j
@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class WXServiceImpl implements WXService {

    @Value("${token.value}")
    public String token;

    /**
     * 开发者通过检验 signature 对请求进行校验（下面有校验方式）。
     * 若确认此次 GET 请求来自微信服务器，请原样返回 echostr 参数内容，则接入生效，成为开发者成功，否则接入失败。
     * <p>
     * 加密/校验流程如下：
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与 signature 对比，标识该请求来源于微信
     *
     * @param weiChatParam
     */

    @Override
    public boolean check(WeiChatParam weiChatParam) {
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = {token, weiChatParam.getTimestamp(), weiChatParam.getNonce()};
        Arrays.sort(strs);
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0] + strs[1] + strs[2];
        String mysign = Sha1Util.encode(str);
        System.out.println("加密前：" + str);
        System.out.println("Signature:" + weiChatParam.getSignature());
        System.out.println("mysign:：" + mysign);
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return weiChatParam.getSignature().equals(mysign);
    }

}
