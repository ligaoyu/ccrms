package com.iproject.ccrms.customer.service;

import com.iproject.ccrms.customer.dao.CustomerDao;
import com.iproject.ccrms.user.service.UserService;
import com.iproject.ccrms.user.service.UserTokenService;
import com.iproject.entity.UserEntity;
import com.iproject.entity.UserTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenService userTokenService;

    public void getCustomer(String token){
        UserTokenEntity userTokenEntity = userTokenService.getValidToken(token);
        UserEntity userEntity = userService.findUserById(userTokenEntity.getId());
        customerDao.findCustomerByDepartmentId(userEntity.get)
    }

}
