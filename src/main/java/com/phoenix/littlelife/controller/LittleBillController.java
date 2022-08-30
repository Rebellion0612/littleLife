package com.phoenix.littlelife.controller;

import com.phoenix.littlelife.common.LittleException;
import com.phoenix.littlelife.constant.Urls;
import com.phoenix.littlelife.service.LittleBillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Phoenix Fly
 * @create 2022/8/30 21:57
 */
@RestController()
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Urls.baseUrl + "/bill")
public class LittleBillController {

    private final LittleBillService littleBillService;

    @GetMapping("/test/{one}")
    public String test(@PathVariable("one") Integer one) {
        if (one == 1) {
            throw new LittleException("小问题");
        }
        return "test hello";
    }

}
