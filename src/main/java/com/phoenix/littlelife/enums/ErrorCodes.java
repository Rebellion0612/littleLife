package com.phoenix.littlelife.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @Author Phoenix Fly
 * @create 2022/7/3 16:02
 */
@Getter
@AllArgsConstructor
public enum ErrorCodes {

    /**
     * 异常码
     */
    SUCCESS(0, "成功"),
    NO_CODE(100, "统一错误处理"),
    FAIL(101, "接口调用出错"),
    TAG_REPEAT(102, "标签重复"),
    SERVICE_ERROR(103, "服务异常，请稍候重试");

    private Integer code;

    private String message;

    public static ErrorCodes getErrorCode(Integer code) {
        return Arrays.stream(values()).filter(i -> i.code.equals(code))
                .findFirst().orElse(SERVICE_ERROR);
    }
}
