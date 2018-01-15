package com.iproject.ccrms.user.controller;

import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.base.utils.MD5Util;
import com.iproject.ccrms.base.utils.ResultUtil;
import com.iproject.ccrms.user.service.UserService;
import com.iproject.ccrms.user.vo.LoginVO;
import com.iproject.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ligaoyu on 18/1/8.
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping(value = "/login")
//    public Result login(@Valid LoginVO loginVO, BindingResult bindingResult){
//        if (bindingResult.hasErrors()) {
//            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
//        }
//
//        UserDetails userDetails = userService.loadUserByUsername(loginVO.getUsername());
//
//
//
//        if(result.getRetCode().equals(200)){
//            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            HttpServletRequest request = attributes.getRequest();
//            HttpSession session = request.getSession();
//            session.setAttribute("userId",loginVO.getUsername());
//        }
//
//        return result;
//    }

    @GetMapping
    public Result userList(){
        List<UserEntity> users = userService.userList();
        return ResultUtil.success(users);
    }

    /**
     * 该方法是注册用户的方法，默认放开访问控制
     * @param user
     */
    @PostMapping(value = "/signup")
    public Result signUp(@Valid LoginVO user) {
        UserEntity user1 = userService.findUserByLoginName(user.getUsername());
        if(null != user1){
            return ResultUtil.error(0,"用户名已存在");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setLoginname(user.getUsername());
        userEntity.setPassword(MD5Util.getMD5(user.getUsername() + user.getPassword()));
        userService.save(userEntity);
        return ResultUtil.success();
    }




}
