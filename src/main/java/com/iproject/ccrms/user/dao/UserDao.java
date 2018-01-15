package com.iproject.ccrms.user.dao;

import com.iproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ligaoyu on 18/1/8.
 */
public interface UserDao extends JpaRepository<UserEntity, Integer> {

    @Query(value = "select d from UserEntity d where d.loginname = ?1 ")
    UserEntity findUserByLoginName(String loginName);


}
