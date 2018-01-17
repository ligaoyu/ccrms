package com.iproject.ccrms.user.controller;

import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.base.redis.service.RedisService;
import com.iproject.ccrms.base.utils.MD5Util;
import com.iproject.ccrms.base.utils.ResultUtil;
import com.iproject.ccrms.user.service.UserService;
import com.iproject.ccrms.user.vo.LoginVO;
import com.iproject.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private RedisService redisService;

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

    @GetMapping(value = "/test")
    public String test(HttpServletRequest request){
        System.out.println("test method .......");
        String token = request.getHeader("Authorization");
        String str = (String) redisService.get(token);
        System.out.println("token is : "+token);
        System.out.println("str is : "+str);
        return "str is : " + str;
    }



    @GetMapping(value = "/testAdd")
    public Result testAdd(@RequestParam String key ,@RequestParam String value){
        System.out.println("testAdd method .......");
        redisService.set(key,value);
        return ResultUtil.success();
    }

    @GetMapping(value = "/testget")
    public String testget(@RequestParam String key){
        System.out.println("testget method .......");
        String str  = (String)redisService.get(key);
        System.out.println("str is : "+str);
        return str;
    }



}
