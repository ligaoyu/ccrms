package com.iproject.ccrms.base.handle;

import com.iproject.ccrms.base.enums.ResultEnum;
import com.iproject.ccrms.base.exception.BaseException;
import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.base.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ligaoyu on 18/1/17.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof BaseException){
            BaseException baseException = (BaseException) e;
            return ResultUtil.error(baseException.getCode(),baseException.getMessage());
        }else{
            logger.error("系统异常{}",e);
            return ResultUtil.error(ResultEnum.InternalServerError);
        }
    }

}
