package com.code.common.web.domain.common;

import com.code.common.web.domain.constant.Constants;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用响应
 */
@Data
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = -5888997213964143847L;
    private int error;
    private String msg;
    private T data;
    private String redirectUrl;

    public CommonResult(int error, String msg, T data) {
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public CommonResult(int error, String redirectUrl) {
        this.error = error;
        this.redirectUrl = redirectUrl;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(Constants.SUC_CODE, Constants.SUC_MSG, data);
    }

    public static <T> CommonResult<T> fail(String msg) {
        return new CommonResult<>(Constants.ERR_CODE, msg, null);
    }

    public static <T> CommonResult<T> fail(int code, String msg) {
        return new CommonResult<>(code, msg, null);
    }

    public static <T> CommonResult<T> fail(int code, String msg, T data) {
        return new CommonResult<>(code, msg, data);
    }

}
