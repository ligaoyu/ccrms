package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 会议登记表
 * Created by ligaoyu on 18/1/2.
 */
@Data
@Entity
@Table(name = "t_conference_roster")
public class ConferenceRosterEntity {

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
     * 会议id
     */
    @Column(name = "conference_id")
    private Integer conferenceId;

    /**
     * 参加者id
     */
    @Column(name = "customeri_id")
    private Integer customeriId;

    /**
     * 参与者姓名
     */
    private String name;

    /**
     * 参与者类型 0=线索，1=会员，2=职工
     */
    private Integer type;

    /**
     * 状态 0=未出席，1=出席
     */
    private Integer state;

    /**
     * 到达时间
     */
    @Column(name = "arrive_time")
    private Date arriveTime;

    /**
     * 离开时间
     */
    @Column(name = "leave_time")
    private Date leaveTime;

    /**
     * 交通方式 0=飞机，1=火车，2=自驾
     */
    private Integer transport;

    /**
     * 班次
     */
    private String flight;

    /**
     * 是否需要接机 0=不需要，1=需要
     */
    @Column(name = "airport_pickup")
    private Integer airportPickup;

    /**
     * 住宿
     */
    private String accommodation;

    /**
     * 胸牌 0=无，1=有
     */
    private Integer badge;

}
