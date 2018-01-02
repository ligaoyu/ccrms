package com.iproject.entity;

/**
 * 客户公司信息表
 * Created by ligaoyu on 18/1/2.
 */

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_company")
public class CompanyEntity {

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
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 营业执照号
     */
    @Column(name = "license_number")
    private String licenseNumber;

    /**
     * 注册资本 单位 元
     */
    @Column(name = "registered_capital")
    private Integer registeredCapital;

    /**
     * 法人
     */
    @Column(name = "legal_personality")
    private String legalPersonality;

    /**
     * 注册地址
     */
    private String adress;

    /**
     * 经营范围
     */
    @Column(name = "business_scope")
    private String businessScope;

}
