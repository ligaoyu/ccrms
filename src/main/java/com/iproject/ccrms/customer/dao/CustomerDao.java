package com.iproject.ccrms.customer.dao;

import com.iproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by ligaoyu on 18/1/8.
 */
public interface CustomerDao extends JpaRepository<CustomerEntity, Integer> {

    @Query(value = "select d from CustomerEntity d where d.departmentId = ?1 ")
    CustomerEntity findCustomerByDepartmentId(Integer departmentId);


}
