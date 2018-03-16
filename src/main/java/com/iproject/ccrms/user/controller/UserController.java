package com.iproject.ccrms.user.controller;

import com.iproject.ccrms.base.constant.Constants;
import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.base.utils.MD5Util;
import com.iproject.ccrms.base.utils.ResultUtil;
import com.iproject.ccrms.user.model.LoginModel;
import com.iproject.ccrms.user.service.UserService;
import com.iproject.ccrms.user.service.UserTokenService;
import com.iproject.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * 用户操作类
 * Created by ligaoyu on 18/1/8.
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenService userTokenService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping
    public Result userList(){
        List<UserEntity> users = userService.userList();
        return ResultUtil.success(users);
    }

    /**
     * 用户登陆接口
     * @param loginModel
     * @param bindingResult
     * @param response
     * @return
     */
    @PostMapping(value = "/login")
    public Result login(@Valid LoginModel loginModel, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        //校验登录
        UserEntity user = userService.loginCheck(loginModel);

        String token = userTokenService.createToken(user.getId());

        response.addHeader(Constants.AUTHORIZATION,token);
        return ResultUtil.success();
    }

    /**
     * token验证接口
     * @param request
     * @return
     */
//    @GetMapping
//    public Result getValidToken(HttpServletRequest request){
//        String token = (String)request.getHeader(Constants.AUTHORIZATION);
//        if(token == null){
//            return ResultUtil.error(ResultEnum.InvalidToken);
//        }
//        boolean flag  = tokenManagerService.getValidToken(token);
//        if(flag){
//            return ResultUtil.success();
//        }else{
//            return ResultUtil.error(ResultEnum.InvalidToken);
//        }
//    }

    /**
     * 该方法是注册用户的方法，默认放开访问控制
     * @param user
     */
    @PostMapping(value = "/signup")
    public Result signUp(@Valid LoginModel user) {
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
