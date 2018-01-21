package com.iproject.ccrms.user.service;

import com.iproject.ccrms.base.enums.ResultEnum;
import com.iproject.ccrms.base.exception.BaseException;
import com.iproject.ccrms.base.utils.MD5Util;
import com.iproject.ccrms.user.dao.UserDao;
import com.iproject.ccrms.token.model.LoginModel;
import com.iproject.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ligaoyu on 18/1/8.
 */
@Service
public class UserService{

    @Autowired
    private UserDao userDao;

    /**
     * 登陆验证
     * @param username 用户登录名
     * @return
     */
    public UserEntity loginCheck(LoginModel loginModel){
        UserEntity user = userDao.findUserByLoginName(loginModel.getUsername());
        if(user == null){
            throw new BaseException(ResultEnum.UserNotFound);
        }
        String password = user.getPassword();
        String inPassWord = MD5Util.getMD5(loginModel.getUsername()+ loginModel.getPassword());
        if(password.equals(inPassWord)){
            //如果登录认证成功返回用户信息
            return user;
        }else{
            throw new BaseException(ResultEnum.WorngPassword);
        }
    }

    public List<UserEntity> userList(){
        return userDao.findAll();
    }

    public UserEntity findUserByLoginName(String username){
        return userDao.findUserByLoginName(username);
    }

    public void save(UserEntity user) {
        userDao.save(user);
    }
}
