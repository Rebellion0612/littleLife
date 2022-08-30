package com.phoenix.littlelife.common;

import com.phoenix.littlelife.enums.ErrorCodes;

/**
 * @Author Phoenix Fly
 * @create 2022/7/3 16:01
 */
public class LittleException extends RuntimeException {
    private Integer code;
    private String message;

    public LittleException(ErrorCodes exceptionCode) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }

    public LittleException(String message) {
        this.message = message;
        this.code = ErrorCodes.FAIL.getCode();
    }

    public LittleException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
