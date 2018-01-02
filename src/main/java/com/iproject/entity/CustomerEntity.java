package com.iproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 客户信息表
 * Created by ligaoyu on 18/1/2.
 */
@Data
@Entity
@Table(name = "t_customer")
public class CustomerEntity {

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
     * 所属部门ID
     */
    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 邀请人ID 可以用于计算员工绩效或合伙人分润
     */
    @Column(name = "inviter_id")
    private Integer inviterId;

    /**
     * 客户类型 0=全款会员，1=龙弟子,2=全球创办人，3=期费会员
     */
    private Integer type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0=女，1=男
     */
    private Integer gender;

    /**
     * 身份证号
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * Email
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * qq号
     */
    private String QQ;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 职务 客户原公司职务
     */
    private Integer position;

    /**
     * 学历 0=中专，1=本科
     */
    private Integer education;

    /**
     * 原公司ID
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 状态 0=注销，1=生效，2=期费会员到期
     */
    private Integer state;


}
