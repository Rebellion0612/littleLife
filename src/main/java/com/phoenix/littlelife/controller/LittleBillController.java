package com.phoenix.littlelife.controller;

import com.phoenix.littlelife.common.ApiResult;
import com.phoenix.littlelife.constant.Urls;
import com.phoenix.littlelife.data.param.BillParam;
import com.phoenix.littlelife.data.param.EventParam;
import com.phoenix.littlelife.data.param.FamilyParam;
import com.phoenix.littlelife.data.param.TagParam;
import com.phoenix.littlelife.data.vo.BillGroupVo;
import com.phoenix.littlelife.service.LittleBillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ApiResult<List<BillGroupVo>> test(@PathVariable("one") Integer one) {

        return ApiResult.success(littleBillService.queryBillGroup());
    }

    /**
     * 前端传递的是对象
     */
    @PostMapping("/lyy")
    public String testTwo(@RequestBody BillParam param) {
        System.out.println("testTwo");
        return "testTwo";
    }

    @PostMapping("/createFamily")
    public ApiResult testFamily(@RequestBody FamilyParam param) {
        littleBillService.createFamily(param);
        return ApiResult.success();
    }

    @PostMapping("/createBill")
    public ApiResult testBill(@RequestBody BillParam param) {
        littleBillService.createBill(param);
        return ApiResult.success();
    }

    @PostMapping("/createTag")
    public ApiResult testBill(@RequestBody TagParam param) {
        littleBillService.createTag(param);
        return ApiResult.success();
    }

    @PostMapping("/joinFamily")
    public ApiResult testJoinFamily(@RequestBody @Valid FamilyParam param) {
        littleBillService.joinFamily(param);
        return ApiResult.success();
    }

    @PostMapping("/createEvent")
    public ApiResult testEvent(@RequestBody @Valid EventParam param){
        littleBillService.createEvent(param);
        return ApiResult.success();
    }
}
