package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 讲师信息表
 * Created by ligaoyu on 18/1/2.
 */

@Data
@Entity
@Table(name = "t_lecturer")
public class LecturerEntity {

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
     * 讲师姓名
     */
    private String name;

    /**
     * 	状态	0=注销，1=生效
     */
    private Integer state;
}
