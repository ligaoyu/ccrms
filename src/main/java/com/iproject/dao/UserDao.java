package com.iproject.dao;

import com.iproject.model.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ligaoyu on 17/12/30.
 */
public interface UserDao extends JpaRepository<UsrUser, Integer> {
}
