package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 交易流水表
 * Created by ligaoyu on 18/1/2.
 */
@Data
@Entity
@Table(name = "t_trade")
public class TradeEntity {

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
     * 订单id
     */
    @Column(name = "order_id")
    private Integer  orderId;

    /**
     * 金额
     */
    private Integer amount;

    /**
     * 状态 0=初始化，1=完成，2=退单
     */
    private Integer state;

    /**
     * 描述
     */
    private String description;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 完成时间时间
     */
    @Column(name = "end_time")
    private Date endTime;
}
