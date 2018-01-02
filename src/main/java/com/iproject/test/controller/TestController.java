package com.iproject.test.controller;

import com.iproject.test.dao.UserDao;
import com.iproject.test.model.UsrUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ligaoyu on 17/12/30.
 */

@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public List<UsrUser> helloworld(){
        return userDao.findAll() ;
    }

}
