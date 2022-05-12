package com.cwsya.wtxSystem.exception.handling;

import com.cwsya.wtxSystem.exception.ParameterException;
import com.cwsya.wtxSystem.exception.ToolException;
import com.cwsya.wtxSystem.pojo.Result;
import com.cwsya.wtxSystem.pojo.ResultCodeEnum;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cws
 */
@ControllerAdvice
@ResponseBody
public class ToolExceptionHandler {
    @ExceptionHandler({ToolException.class})
    public Result<?> parameterException(){
        return new Result<>(ResultCodeEnum.NOT_TOOL);
    }
}
