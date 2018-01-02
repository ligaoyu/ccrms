package com.iproject.entity;

/**
 * 线索客户交流记录表
 * Created by ligaoyu on 18/1/2.
 */

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_clue_record")
public class ClueRecordEntity {

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
     * 线索id
     */
    @Column(name = "clue_id")
    private Integer clueId;

    /**
     * 处理人id
     */
    @Column(name = "handler_id")
    private Integer handlerId;

    /**
     * 沟通方式 0=电话，1=面谈
     */
    private Integer type;

    /**
     * 交流时间
     */
    @Column(name = "communicate_time")
    private Date communicateTime;

    /**
     * 下次回访时间
     */
    @Column(name = "callback_time")
    private Date callbackTime;

    /**
     * 内容
     */
    private String content;

    /**
     * 备注
     */
    private String comment;

    /**
     * 	状态	0=注销，1=生效
     */
    private Integer state;
}
