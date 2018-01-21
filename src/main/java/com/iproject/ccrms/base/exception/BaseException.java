package com.iproject.ccrms.base.exception;

import com.iproject.ccrms.base.enums.ResultEnum;
import lombok.Data;

/**
 * Created by ligaoyu on 18/1/17.
 */
@Data
public class BaseException extends RuntimeException{

    private Integer code;

    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public BaseException(Integer code,String message){
        super(message);
        this.code = code;
    }



}
