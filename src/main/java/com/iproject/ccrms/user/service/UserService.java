package com.iproject.ccrms.user.service;

import com.iproject.ccrms.user.dao.UserDao;
import com.iproject.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by ligaoyu on 18/1/8.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    public UserDetails loadUserByUsername(String username){
        UserEntity user = userDao.findUserByLoginName(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
//            return ResultUtil.error(ResultEnum.Forbidden);
        }
        return new org.springframework.security.core.userdetails.User(user.getLoginname(), user.getPassword(), Collections.<GrantedAuthority>emptyList());
//        String password = loginVO.getPassword();
//        String inPassWord = MD5Util.getMD5(username+password);
//        if(user.getPassword().equals(inPassWord)){
//            //如果登录认证成功讲loginVO里的username替换为用户ID 存进Session
//            loginVO.setUsername(user.getId().toString());
//            return ResultUtil.success();
//        }else{
//            return ResultUtil.error(ResultEnum.Forbidden);
//        }
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
