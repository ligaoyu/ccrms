package com.iproject.entity;

/**
 * 客户供求信息表
 * Created by ligaoyu on 18/1/2.
 */

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_customer_demand")
public class CustomerDemandEntity {


    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 入库时间
     */
    private Date intime;

    /**
     * 最后修改时间
     */
    private Date modtime;

    /**
     * 修改人ID
     */
    @Column(name = "mod_user")
    private Integer modUser;

    /**
     * 所属部门ID
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 需求资源
     */
    private String need;

    /**
     * 提供资源
     */
    private String provide;

    /**
     * 信息类别 0=提供，1=需求
     */
    private Integer type;
}
