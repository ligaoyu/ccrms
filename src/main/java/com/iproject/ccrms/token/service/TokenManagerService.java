package com.iproject.ccrms.token.service;

import com.iproject.ccrms.token.model.TokenModel;

/**
 * 对token进行操作的接口
 * Created by ligaoyu on 18/1/17.
 */
public interface TokenManagerService {

    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public TokenModel createToken(Integer userId);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(String token);

    /**
     * 从字符串中解析token
     * @param token 加密后的字符串
     * @return
     */
    public TokenModel getUserIdFromToken(String token);

    /**
     * 清除token
     * @param token 登录用户的token
     */
    public void deleteToken(String token);

}
