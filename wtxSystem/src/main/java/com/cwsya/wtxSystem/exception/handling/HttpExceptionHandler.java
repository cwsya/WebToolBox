package com.cwsya.wtxSystem.exception.handling;

import com.cwsya.wtxSystem.exception.ParameterException;
import com.cwsya.wtxSystem.pojo.Result;
import com.cwsya.wtxSystem.pojo.ResultCodeEnum;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cws
 */

@ControllerAdvice
@ResponseBody
public class HttpExceptionHandler {

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class,HttpMediaTypeNotSupportedException.class})
    public Result<?> httpRequestMethodNotSupportedException(){
        return new Result<>(ResultCodeEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION);
    }
    @ExceptionHandler({ParameterException.class, HttpMessageNotReadableException.class})
    public Result<?> parameterException(){
        return new Result<>(ResultCodeEnum.REQUEST_EXCEPTION);
    }
}
