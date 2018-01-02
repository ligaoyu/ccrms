package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 会议表
 * Created by ligaoyu on 18/1/2.
 */

@Data
@Entity
@Table(name = "t_conference")
public class ConferenceEntity {

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
     * 讲师id
     */
    private Integer lecturer;

    /**
     * 类型 0=总公司会议，1=分公司会议
     */
    private Integer type;

    /**
     * 状态 0=注销，1=生效
     */
    private Integer state;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 签到开始时间
     */
    @Column(name = "sign_start_time")
    private Date signStartTime;

    /**
     * 签到结束时间
     */
    @Column(name = "sign_end_time")
    private Date signEndTime;

    /**
     * 酒店名
     */
    private String hotel;

    /**
     * 酒店地址
     */
    @Column(name = "hotel_address")
    private String hotelAddress;

    /**
     * 接待总负责人
     */
    private Integer conductor;

    /**
     * 接机负责人
     */
    @Column(name = "tans_conductor")
    private Integer tansConductor;

    /**
     * 住宿接待负责人
     */
    @Column(name = "hotel_conductor")
    private Integer hotelConductor;
}
