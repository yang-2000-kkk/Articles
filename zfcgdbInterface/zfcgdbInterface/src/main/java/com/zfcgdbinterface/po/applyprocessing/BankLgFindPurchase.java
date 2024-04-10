package com.zfcgdbinterface.po.applyprocessing;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 银行保函(采购类)
 * @author zht
 * @date 2019/7/25 11:27
 **/
@Getter
@Setter
public class BankLgFindPurchase {

    private Integer id;

    private Integer typeId;

    /**
     * 银行保函
     */
    private String bankLg;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 担保期限
     */
    private String term;

    /**
     *  担保金额
     */
    private BigDecimal guaranteeSum;

    /**
     * 企业性质
     */
    private String nature;

    /**
     * 保函业主方（甲方）对应资质
     */
    private String aQualification;

    /**
     * 对银行要求
     */
    private String equirement;

    /**
     * 申请人电话
     */
    private String applicantTel;

    /**
     * 申请人邮箱
     */
    private String applicantEmail;

    /**
     * 申请人姓名
     */
    private String applicantName;
}
