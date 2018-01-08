package com.iproject.ccrms.base.utils;

import com.iproject.ccrms.base.enums.ResultEnum;
import com.iproject.ccrms.base.model.Result;

/**
 * Created by ligaoyu on 18/1/8.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result(ResultEnum.SUCCESS);
        result.setResult(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String message){
        Result result = new Result();
        result.setRetCode(code);
        result.setRetMsg(message);
        result.setResult(null);
        return result;
    }

    public static Result error(ResultEnum resultEnum){
        Result result = new Result(resultEnum);
        result.setResult(null);
        return result;
    }

}
