package com.lizhi.weather.handle;

import com.lizhi.weather.enums.ResultEnum;
import com.lizhi.weather.exception.GlobalException;
import com.lizhi.weather.utils.ResultUtil;
import com.lizhi.weather.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Demo class
 *
 * @author xulizhi-lenovo
 * @date 2019/5/17
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultVO<String> exceptionHandler(Exception e){
        log.error("【异常信息】{}", e.getMessage());
        if(e instanceof GlobalException) {
            GlobalException globalException = (GlobalException)e;
            return ResultUtil.error(globalException.getResultEnum());
        }else if(e instanceof BindException){
            BindException bindException = (BindException)e;
            List<ObjectError> errors = bindException.getAllErrors();
            ObjectError error = errors.get(0);
            String paramErrorMsg = error.getDefaultMessage();
            return ResultUtil.error(ResultEnum.CONTROLLER_PARAM_ERROR.fillArgs(paramErrorMsg));
        }else{
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.ERROR);
        }
    }

}
