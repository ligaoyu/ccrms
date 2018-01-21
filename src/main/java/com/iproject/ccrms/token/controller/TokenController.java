package com.iproject.ccrms.token.controller;

import com.iproject.ccrms.base.constant.Constants;
import com.iproject.ccrms.base.enums.ResultEnum;
import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.base.utils.ResultUtil;
import com.iproject.ccrms.token.model.TokenModel;
import com.iproject.ccrms.token.service.TokenManagerService;
import com.iproject.ccrms.user.service.UserService;
import com.iproject.ccrms.token.model.LoginModel;
import com.iproject.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by ligaoyu on 18/1/17.
 */
@RequestMapping("/token")
@RestController
public class TokenController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManagerService tokenManagerService;

    @PostMapping(value = "/login")
    public Result login(@Valid LoginModel loginModel, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        //校验登录
        UserEntity user = userService.loginCheck(loginModel);

        TokenModel tokenModel = tokenManagerService.createToken(user.getId());

        response.addHeader(Constants.AUTHORIZATION,tokenModel.getToken());
        return ResultUtil.success();
    }

    @GetMapping
    public Result checkToken(HttpServletRequest request){
       String token = (String)request.getHeader(Constants.AUTHORIZATION);
       if(token == null){
           return ResultUtil.error(ResultEnum.InvalidToken);
       }
       boolean flag  = tokenManagerService.checkToken(token);
       if(flag){
           return ResultUtil.success();
       }else{
           return ResultUtil.error(ResultEnum.InvalidToken);
       }
    }

    @GetMapping(value = "/logout")
    public Result exit(HttpServletRequest request){
        String token = (String)request.getHeader(Constants.AUTHORIZATION);
        if(token == null){
            return ResultUtil.error(ResultEnum.InvalidToken);
        }
        boolean flag  = tokenManagerService.checkToken(token);
        if(flag){
            tokenManagerService.deleteToken(token);
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.InvalidToken);
        }
    }

}
