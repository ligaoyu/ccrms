package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 部门实体类基本信息
 * Created by ligaoyu on 17/12/30.
 */
@Data
@Entity
@Table(name = "t_department")
public class DepartmentEntity {

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
     * 部门名称
     */
    private String name;

    /**
     * 成立时间
     */
    @Column(name = "establishment_time")
    private Date establishmentTime;

    /**
     * 部门位置
     */
    private String location;


    /**
     * 类型 0分公司 1总公司
     */
    private Integer type;

    /**
     * 状态 0注销 1生效
     */
    private Integer state;

}
