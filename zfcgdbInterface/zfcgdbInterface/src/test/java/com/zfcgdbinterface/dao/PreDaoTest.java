package com.zfcgdbinterface.dao;

import com.zfcgdbinterface.po.applyprocessing.BankLgFindEngineering;
import com.zfcgdbinterface.po.applyprocessing.BankLgFindPurchase;
import com.zfcgdbinterface.po.applyprocessing.CompanyLgFind;
import com.zfcgdbinterface.po.loifind.LOIFind;
import com.zfcgdbinterface.po.loifind.LOIFindVO;
import com.zfcgdbinterface.po.mail.Subscriber;
import com.zfcgdbinterface.po.news.News;
import com.zfcgdbinterface.po.news.NewsDetail;
import com.zfcgdbinterface.po.news.Qus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zht
 * @date 2019/7/18 23:44
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class PreDaoTest {

    @Resource
    private PreDao preDao;

    @Test
    public void getHomeList() {
        preDao.homeList();
    }

    @Test
    public void getContact() {
        String contact = String.valueOf(preDao.contact());

        System.out.println(contact);
        String regex = "FIX_ACC:(.*?),OP_FLAG";

        Matcher matcher = Pattern.compile(regex).matcher(contact);
        while (matcher.find()) {
            String ret = matcher.group(1);
            System.out.println(ret);
        }
        //System.out.println(contact);
    }

    @Test
    public void getBusinessIntro1() {
        preDao.businessIntro1List("投标保函");
    }

    @Test
    public void getBusinessIntro2() {
        preDao.businessIntro2List("");
    }

    @Test
    public void getNewsList() {
        preDao.newsList("企业新闻");
    }

    @Test
    public void findNewsSwitch() {
        String str = preDao.findNewsSwitch("企业新闻");
        System.out.println(str);
    }

    @Test
    public void detailList() {
        List<NewsDetail> newsDetailList = preDao.detailList(1);
        for (NewsDetail newsDetail : newsDetailList)
            System.out.println(newsDetail.getTitle());
    }

    @Test
    public void loiFindList() {
        preDao.loiFindList("1");
    }

    @Test
    public void loiFindPic() {
        preDao.loiFindPic("1");
    }

    @Test
    public void news() {
        preDao.news();
    }

    @Test
    public void findImageByType() {
        String[] strings = preDao.findImageByType(1);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    @Test
    public void companyLgFindInsert() {
        CompanyLgFind companyLgFind = new CompanyLgFind();
        companyLgFind.setApplicantName("zht");
        preDao.companyLgFindInsert(companyLgFind);
    }

    @Test
    public void bankLgFindPurchaseInsert() {
        BankLgFindPurchase bankLgFindPurchase = new BankLgFindPurchase();
        bankLgFindPurchase.setApplicantName("zht");
        preDao.bankLgFindPurchaseInsert(bankLgFindPurchase);
    }

    @Test
    public void bankLgFindEngineeringInsert() {
        BankLgFindEngineering bankLgFindEngineering= new BankLgFindEngineering();
        bankLgFindEngineering.setApplicantName("zht");
        bankLgFindEngineering.setApplicantEmail("");
        bankLgFindEngineering.setApplicantTel("");
        bankLgFindEngineering.setAQualification("");
        bankLgFindEngineering.setBankLg("");
        bankLgFindEngineering.setEquirement("");
        bankLgFindEngineering.setGrade("");
        bankLgFindEngineering.setGuaranteeSum(new BigDecimal("0"));
        bankLgFindEngineering.setNature("");
        bankLgFindEngineering.setProjectName("");
        bankLgFindEngineering.setQualification("");
        bankLgFindEngineering.setTerm("");
        bankLgFindEngineering.setTypeId(new Integer("3"));
        preDao.bankLgFindEngineeringInsert(bankLgFindEngineering);
    }

    @Test
    public void loiFindIsTrue() {
        String str = preDao.loiFindIsTrue("201907231118");
        List<LOIFind> loiFindList = preDao.loiFindList("201907231118");
        List<LOIFindVO> loiFindVOList = preDao.loiFindVOList("201907231118");
        System.out.println(loiFindList.get(0).getIsTrue());
        System.out.println(loiFindVOList.get(0).getIsTrue());
        System.out.println(str);
    }

    @Test
    public void findMailIntro() {
        Subscriber subscriber = preDao.findMailIntro();
        System.out.println(subscriber.getSubscriberMail());
        System.out.println(subscriber.getSubscriberMailHost());
        System.out.println(subscriber.getSubscriberMailPassword());
    }

    @Test
    public void qusList() {
        preDao.qusList();
    }

    @Test
    public void qusByisTrueList() {
        List<Qus> list = preDao.qusByisTrueList();
        for (Qus qus : list) {
            System.out.println(qus);
        }
    }

}