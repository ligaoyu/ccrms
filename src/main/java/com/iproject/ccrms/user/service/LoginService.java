package com.iproject.ccrms.user.service;

import com.iproject.ccrms.base.enums.ResultEnum;
import com.iproject.ccrms.base.model.Result;
import com.iproject.ccrms.base.utils.MD5Util;
import com.iproject.ccrms.base.utils.ResultUtil;
import com.iproject.ccrms.user.dao.UserDao;
import com.iproject.ccrms.user.vo.LoginVO;
import com.iproject.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ligaoyu on 18/1/8.
 */
@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public Result loginCheck(LoginVO loginVO){
        String username = loginVO.getUsername();
        UserEntity user = userDao.findByLoginName(username);
        if(user == null){
            return ResultUtil.error(ResultEnum.Forbidden);
        }

        String password = loginVO.getPassword();
        String inPassWord = MD5Util.getMD5(username+password);
        if(user.getPassword().equals(inPassWord)){
            return ResultUtil.success();
        }else{
            return ResultUtil.error(ResultEnum.Forbidden);
        }
    }

}
