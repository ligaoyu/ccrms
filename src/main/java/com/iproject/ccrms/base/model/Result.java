package com.iproject.ccrms.base.model;

import com.iproject.ccrms.base.enums.ResultEnum;
import lombok.Data;

/**
 * Created by ligaoyu on 18/1/8.
 */
@Data
public class Result<T> {

    private Integer retCode;

    private String retMsg;

    private T result;

    public Result(){

    }

    public Result(ResultEnum resultEnum){
        this.retCode = resultEnum.getCode();
        this.retMsg = resultEnum.getMessage();
    }

}
