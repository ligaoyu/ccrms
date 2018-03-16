package com.iproject.ccrms.user.service;

import com.iproject.ccrms.base.utils.DateUtil;
import com.iproject.ccrms.user.dao.UserTokenDao;
import com.iproject.entity.UserTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserTokenService {

    @Autowired
    private UserTokenDao userTokenDao;

    public UserTokenEntity getValidToken(String token){
        return userTokenDao.getValidToken(token,DateUtil.getBeforeHourTime(-20));
    }

    /**
     * 创建token
     * @param userId
     */
    public String createToken(Integer userId){
        String token = UUID.randomUUID().toString().replace("-", "");
        UserTokenEntity userTokenEntity = new UserTokenEntity(new Date(),new Date(),userId,token);
        userTokenDao.save(userTokenEntity);
        return token;
    }

    /**
     * 验证token是否有效
     * @param token
     * @return
     */
    public boolean checkToken(String token){
        if(token == null || "".equals(token)){
            return false;
        }
        UserTokenEntity user = userTokenDao.getValidToken(token,DateUtil.getBeforeHourTime(-20));
        if(user == null){
            return false;
        }else{
            //验证成功认为进行有效操作，更新modtime
            user.setModtime(new Date());
            userTokenDao.save(user);
            return true;
        }
    }

    public void deleteToken(){

    }

    public void deletedisabledToken(){

    }
}
