package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ligaoyu on 17/12/30.
 */
@Data
@Entity
@Table(name = "t_user")
public class UserEntity {

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
     * 关联用户ID
     */
    @Column(name = "relate_id")
    private Integer relateId;

    /**
     * 登录名
     */
    private String loginname;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 状态 0注销。1生效
     */
    private Integer state;

    /**
     * 类别 0员工。1客户
     */
    private Integer type;


}
