package com.iproject.ccrms.user.controller;

import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.base.utils.ResultUtil;
import com.iproject.ccrms.user.service.LoginService;
import com.iproject.ccrms.user.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by ligaoyu on 18/1/8.
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public Result login(@Valid LoginVO loginVO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        Result result = loginService.loginCheck(loginVO);

        if(result.getRetCode().equals(200)){
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("userId",loginVO.getUsername());
        }

        return result;
    }





}
