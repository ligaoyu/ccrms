package com.iproject.ccrms.user.dao;

import com.iproject.entity.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by ligaoyu on 18/1/8.
 */
public interface UserTokenDao extends JpaRepository<UserTokenEntity, Integer> {

    /**
     * 验证token的查询接口
     * @param token
     * @return
     */
    @Query(value = "select d from UserTokenEntity d where d.token = ?1 and d.modtime > ?2 ")
    UserTokenEntity getValidToken(String token , Date date);

    @Query(value = "select d from UserTokenEntity d where d.modtime < ?1 ")
    List<Integer> findByModtime(Date date);



}
