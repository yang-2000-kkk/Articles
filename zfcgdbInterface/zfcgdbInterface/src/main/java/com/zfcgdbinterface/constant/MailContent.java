package com.zfcgdbinterface.constant;

import com.zfcgdbinterface.po.applyprocessing.BankLgFindEngineering;
import com.zfcgdbinterface.po.applyprocessing.BankLgFindPurchase;
import com.zfcgdbinterface.po.applyprocessing.CompanyLgFind;

/**
 * @author zht
 * @date 2019/8/7 16:13
 **/
public class MailContent {

    //TODO
    public static String contentOfMailFor1(CompanyLgFind companyLgFind) {

        String contentOfMail = "保函种类：" + companyLgFind.getTypes() + "\n" +
                "项目名称：" + companyLgFind.getProjectName() + "\n" +
                "担保期限：" + companyLgFind.getTerm() + "年\n" +
                "担保金额：" + companyLgFind.getGuaranteeSum() + "万元\n" +
                "申请人联系电话：" + companyLgFind.getApplicantTel() + "\n" +
                "申请人邮箱：" + companyLgFind.getApplicantEmail() + "\n" +
                "申请人姓名：" + companyLgFind.getApplicantName() + "\n";
        return contentOfMail;
    }

    //TODO
    public static String contentOfMailFor2(BankLgFindPurchase bankLgFindPurchase) {

        String contentOfMail = "保函种类：" + bankLgFindPurchase.getBankLg() + "\n" +
                "项目名称：" + bankLgFindPurchase.getProjectName() + "\n" +
                "担保期限：" + bankLgFindPurchase.getTerm() + "年\n" +
                "担保金额：" + bankLgFindPurchase.getGuaranteeSum() + "万元\n" +
                "企业性质：" + bankLgFindPurchase.getNature() + "\n" +
                "保函业主方（甲方）对应资质：" + bankLgFindPurchase.getAQualification() + "\n" +
                "对银行要求：" + bankLgFindPurchase.getEquirement() + "\n" +
                "申请人联系电话：" + bankLgFindPurchase.getApplicantTel() + "\n" +
                "申请人邮箱：" + bankLgFindPurchase.getApplicantEmail() + "\n" +
                "申请人姓名：" + bankLgFindPurchase.getApplicantName() + "\n";
        return contentOfMail;
    }

    //TODO
    public static String contentOfMailFor3(BankLgFindEngineering bankLgFindEngineering) {

        String contentOfMail = "保函种类：" + bankLgFindEngineering.getBankLg() + "\n" +
                "项目名称：" + bankLgFindEngineering.getProjectName() + "\n" +
                "担保期限：" + bankLgFindEngineering.getTerm() + "年\n" +
                "担保金额：" + bankLgFindEngineering.getGuaranteeSum() + "万元\n" +
                "担保人对应资质：" + bankLgFindEngineering.getQualification() + "\n" +
                "资质等级：" + bankLgFindEngineering.getGrade() + "\n" +
                "企业性质：" + bankLgFindEngineering.getNature() + "\n" +
                "保函业主方（甲方）对应资质：" + bankLgFindEngineering.getAQualification() + "\n" +
                "对银行要求：" + bankLgFindEngineering.getEquirement() + "\n" +
                "申请人联系电话：" + bankLgFindEngineering.getApplicantTel() + "\n" +
                "申请人邮箱：" + bankLgFindEngineering.getApplicantEmail() + "\n" +
                "申请人姓名：" + bankLgFindEngineering.getApplicantName() + "\n";
        return contentOfMail;
    }
}
