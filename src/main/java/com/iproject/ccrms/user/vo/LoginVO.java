package com.iproject.ccrms.user.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by ligaoyu on 18/1/8.
 */
@Data
public class LoginVO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;



}
