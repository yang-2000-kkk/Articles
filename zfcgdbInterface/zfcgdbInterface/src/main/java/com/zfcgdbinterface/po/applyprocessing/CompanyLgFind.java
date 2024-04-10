package com.zfcgdbinterface.po.applyprocessing;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 担保公司保函
 * @author zht
 * @date 2019/7/25 11:22
 **/
@Getter
@Setter
public class CompanyLgFind {

    private Integer id;

    private Integer typeId;

    /**
     * 保函种类
     */
    private String types;

    /**
     *项目名称
     */
    private String projectName;

    /**
     *担保期限
     */
    private String term;

    /**
     *担保金额
     */
    private BigDecimal guaranteeSum;

    /**
     *申请人联系电话
     */
    private String applicantTel;

    /**
     *申请人邮箱
     */
    private String applicantEmail;

    /**
     *申请人姓名
     */
    private String applicantName;
}
