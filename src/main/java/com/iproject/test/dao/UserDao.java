package com.iproject.test.dao;

import com.iproject.test.model.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ligaoyu on 17/12/30.
 */
public interface UserDao extends JpaRepository<UsrUser, Integer> {
}
