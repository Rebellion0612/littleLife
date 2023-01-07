package com.phoenix.littlelife.controller;

import com.alibaba.fastjson.JSON;
import com.phoenix.littlelife.common.ApiResult;
import com.phoenix.littlelife.constant.Urls;
import com.phoenix.littlelife.data.param.WeiChatParam;
import com.phoenix.littlelife.service.WXService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyangyang
 * @date 2023/1/4 16:21
 */
@RestController()
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Urls.baseUrl + "/weixin")
public class WeiChatController {
    private final WXService wxService;

    @GetMapping("/check")
    public ApiResult weiChatCheck(WeiChatParam weiChatParam) {
        log.info("接收到微信请求{}", JSON.toJSON(weiChatParam));
        if (wxService.check(weiChatParam)){
            log.info("微信接入成功");
            return ApiResult.success(weiChatParam.getEchostr());
        }else{
            log.info("微信接入失败");
            return ApiResult.fail("微信接入失败");
        }

    }

    @GetMapping("/test/{one}")
    public  ApiResult weiChatTest(@PathVariable("one") Integer one){

        return ApiResult.success("weixin测试");
    }


}
