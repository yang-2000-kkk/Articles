package com.zfcgdbinterface.controller.exception;

import com.zfcgdbinterface.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局处理 Controller 层异常
 * @author zht
 **/
@ControllerAdvice
@Slf4j
public class ControllerException {

    /**
     * 处理所有不可预知的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse handleException(Exception e) throws Exception {
        e.printStackTrace();
        return ApiResponse.ofError(50000,e.getMessage());
    }
}
