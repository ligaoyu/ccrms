package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 线索信息表
 * Created by ligaoyu on 18/1/2.
 */
@Data
@Entity
@Table(name = "t_user_token")
public class UserTokenEntity {

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
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户token 最大32位长度
     */
    private String token;

    public UserTokenEntity(){

    }

    public UserTokenEntity(Date intime,Date modtime,Integer userId,String token){
        this.intime = intime;
        this.modtime = modtime;
        this.userId = userId;
        this.token = token;
    }

}
