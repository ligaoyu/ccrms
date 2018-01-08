package com.iproject.ccrms.base.enums;

/**
 * Created by ligaoyu on 18/1/8.
 */
public enum ResultEnum {
    SUCCESS(200,"OK"),//成功
    BadRequest(400,"Bad Request"),//通用错误码，和200对应，不需要特殊逻辑的错误，一律返回400
    Unauthorized(401,"Unauthorized"),//所有需要登录验证的接口未登录的一律返回401，用于前端跳转登录页或重新登录
    Forbidden(403,"Forbidden"),//账号或密码错误，login接口专用返回码
    MethodNotAllow(405,"Method Not Allow"),//未授权操作一律返回此状态码
    InternalServerError(500,"Internal Server Error")//服务器端未知错误
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
