package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单表
 * Created by ligaoyu on 18/1/2.
 */
@Data
@Entity
@Table(name = "t_order")
public class OrderEntity {
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
     * 所属部门id
     */
    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 客户id
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 订单类型 0=转正，1=加盟合伙人
     */
    @Column(name = "order_type")
    private Integer orderType;

    /**
     * 付款方式 0=全款，1=分期
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 状态 0=初始化，1=完成，2=退单
     */
    private Integer state;

    /**
     * 订单金额
     */
    private Integer amount;

    /**
     * 下单时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 完成时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 订单描述
     */
    private String description;
}
