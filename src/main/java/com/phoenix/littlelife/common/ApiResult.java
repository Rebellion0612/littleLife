package com.phoenix.littlelife.common;

import com.phoenix.littlelife.enums.ErrorCodes;
import lombok.Data;

import static com.phoenix.littlelife.enums.ErrorCodes.NO_CODE;
import static com.phoenix.littlelife.enums.ErrorCodes.SUCCESS;

/**
 * @Author Phoenix Fly
 * @create 2022/8/30 22:14
 */
@Data
public class ApiResult<T> {

    private Integer code;

    private String message;

    private T data;

    public ApiResult(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public static <E> ApiResult<E> success(E data) {
        return new ApiResult<>(data, SUCCESS.getCode(), SUCCESS.getMessage());
    }

    public static <E> ApiResult<E> fail(ErrorCodes codes) {
        return new ApiResult<>(null, codes.getCode(), codes.getMessage());
    }

    public static <E> ApiResult<E> fail(String message) {
        return new ApiResult<>(null, NO_CODE.getCode(), message);
    }

}
