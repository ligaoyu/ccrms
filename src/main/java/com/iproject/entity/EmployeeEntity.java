package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ligaoyu on 17/12/30.
 */
@Data
@Entity
@Table(name = "t_employee")
public class EmployeeEntity {

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
     * 部门ID
     */
    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0女  1男
     */
    private Integer gender;

    /**
     * 身份证
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 电话号
     */
    private String mobile;

    /**
     * 职位 0=资本顾问，1=办公司主任
     */
    private Integer  position;

    /**
     * 学历 0=中专，1=本科
     */
    private Integer education;

    /**
     * 状态 0=注销，1=生效
     */
    private Integer state;

}
