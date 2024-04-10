package com.zfcgdbinterface.dao;

import com.zfcgdbinterface.po.CompanyIntro;
import com.zfcgdbinterface.po.Contact;
import com.zfcgdbinterface.po.Home;
import com.zfcgdbinterface.po.applyprocessing.BankLgFindEngineering;
import com.zfcgdbinterface.po.applyprocessing.BankLgFindPurchase;
import com.zfcgdbinterface.po.applyprocessing.CompanyLgFind;
import com.zfcgdbinterface.po.business.BusinessIntro1;
import com.zfcgdbinterface.po.business.BusinessIntro2;
import com.zfcgdbinterface.po.loifind.LOIFind;
import com.zfcgdbinterface.po.loifind.LOIFindVO;
import com.zfcgdbinterface.po.mail.Subscriber;
import com.zfcgdbinterface.po.news.HomeNews;
import com.zfcgdbinterface.po.news.News;
import com.zfcgdbinterface.po.news.NewsDetail;
import com.zfcgdbinterface.po.news.Qus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zht
 * @date 2019/7/18 16:20
 **/
public interface PreDao {

    /**
     * 首页
     */
    List<Home> homeList();
    /**首页中行业咨询：查找最新的两条新闻**/
    List<HomeNews> news();
    /**首页中：合作银行图片*/
    String[] homeBankImg();
    /**客户问答模块*/
    List<Qus> qusByisTrueList();



    /**
     * 合作银行
     */
    String[] bankImg();

    /**
     * 公司简介
     */
    List<CompanyIntro> companyIntroList(String companyType);

    /**
     * 联系我们
     */
    Contact contact();

    /**
     * 业务介绍
     */
    List<BusinessIntro1> businessIntro1List(String businessType);
    List<BusinessIntro2> businessIntro2List(String busiessType);
    String[] businessIntro2Img(Integer businessIntroId);

    /**
     * 新闻
     */
    List<News> newsList(String newsType);
    /**新闻详情*/
    List<NewsDetail> detailList(Integer id);
    /**查看是否开启企业新闻，为true则开启*/
    String findNewsSwitch(String newsType);
    /**客户问答*/
    List<News> qusList();

    /**
     * 保函查询
     */
    List<LOIFind> loiFindList(String loiId);
    List<LOIFindVO> loiFindVOList(String loiId);
    String[] loiFindPic(String loiId);
    String loiFindSwitchs(String loiId);
    String loiFindIsTrue(String loiId);

    /**
     * 轮播图片
     */
    String[] findImageByType(@Param("type") int type);

    /**
     * 文件下载
     */
    String[] findFileName();

    /**
     * 申请办理
     */
    int bankLgFindPurchaseInsert(@Param("pojo") BankLgFindPurchase pojo);
    int bankLgFindEngineeringInsert(@Param("pojo") BankLgFindEngineering pojo);
    int companyLgFindInsert(@Param("pojo") CompanyLgFind pojo);
    Subscriber findMailIntro();
}
