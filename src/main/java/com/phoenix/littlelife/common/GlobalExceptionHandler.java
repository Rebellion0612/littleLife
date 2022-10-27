package com.phoenix.littlelife.common;

import com.phoenix.littlelife.enums.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Phoenix Fly
 * @create 2022/8/30 22:59
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResult defaultException(Exception e) {
        UserContextHolder.clear();
        if (e instanceof BindException) {
            return ApiResult.fail(((BindException) e).getBindingResult().getFieldError().getDefaultMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            return ApiResult.fail(((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage());
        } else {
            log.error("服务发生异常", e);
        }
        return ApiResult.fail(ErrorCodes.SERVICE_ERROR);
    }

    @ExceptionHandler(LittleException.class)
    public ApiResult littleException(LittleException e) {
        UserContextHolder.clear();
        if (ErrorCodes.FAIL.getCode().equals(e.getCode())) {
            return ApiResult.fail(ErrorCodes.FAIL);
        }
        if (ErrorCodes.NO_CODE.getCode().equals(e.getCode())) {
            return ApiResult.fail(e.getMessage());
        }
        log.warn("LittleException:", e);
        return ApiResult.fail(ErrorCodes.getErrorCode(e.getCode()));
    }
}
