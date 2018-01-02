package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 路演表
 * Created by ligaoyu on 18/1/2.
 */
@Data
@Entity
@Table(name = "t_show")
public class ShowEntity {

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
     * 路演题目
     */
    private String theme;

}
