package com.zfcgdbinterface.controller;

import com.zfcgdbinterface.adapter.ImageAdapter;
import com.zfcgdbinterface.annotation.ApplyCheckIP;
import com.zfcgdbinterface.constant.MailConstant;
import com.zfcgdbinterface.constant.MailContent;
import com.zfcgdbinterface.dao.PreDao;
import com.zfcgdbinterface.po.CompanyIntro;
import com.zfcgdbinterface.po.Contact;
import com.zfcgdbinterface.po.Home;
import com.zfcgdbinterface.po.applyprocessing.BankLgFindEngineering;
import com.zfcgdbinterface.po.applyprocessing.BankLgFindPurchase;
import com.zfcgdbinterface.po.applyprocessing.CompanyLgFind;
import com.zfcgdbinterface.po.business.BusinessIntro1;
import com.zfcgdbinterface.po.business.BusinessIntro2;
import com.zfcgdbinterface.po.business.BusinessIntros;
import com.zfcgdbinterface.po.home.Homes;
import com.zfcgdbinterface.po.loifind.*;
import com.zfcgdbinterface.po.mail.Subscriber;
import com.zfcgdbinterface.po.news.*;
import com.zfcgdbinterface.response.ApiResponse;
import com.zfcgdbinterface.service.MailService;
import com.zfcgdbinterface.service.PreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeArray.lastIndexOf;

/**
 * @author zht
 * @date 2019/7/18 19:10
 **/
@RestController
@Api("公司简介")
public class PreController {

    @Resource
    private PreDao preDao;

    @Resource
    private PreService preService;

    @Resource
    private MailService mailService;

    @GetMapping("/getHome")
    @ApiOperation("首页")
    public ApiResponse getHome() {
        List<Home> home = preDao.homeList();

        String[] imgs = preDao.homeBankImg();

        List<HomeNews> news = preDao.news();

        /*客户问答模块*/
        List<Qus> qusByisTrueList = preDao.qusByisTrueList();

        return ApiResponse.ofSuccess(new Homes(home, imgs, news, qusByisTrueList));
    }

    @GetMapping("/getBank")
    @ApiOperation("合作银行")
    public ApiResponse getBank() {
        String[] imgs = preDao.bankImg();

        return ApiResponse.ofSuccess(ImageAdapter.imageList(imgs));
    }

    @GetMapping("/getCompanyIntro")
    @ApiOperation("企业简介")
    public ApiResponse getCompanyIntro() {
        //TODO
        List<CompanyIntro> companyIntroList = preDao.companyIntroList("企业简介");

        return ApiResponse.ofSuccess(companyIntroList);
    }

    /*@GetMapping("/getCompanyCulture")
    @ApiOperation("企业文化")
    public ApiResponse getCompanyCulture() {
        //TODO
        List<CompanyIntro> companyIntroList = preDao.companyIntroList("企业文化");

        return ApiResponse.ofSuccess(companyIntroList);
    }*/

    @GetMapping("/getContact")
    @ApiOperation("联系我们")
    public ApiResponse getContact() {
        Contact contact = preDao.contact();

        return ApiResponse.ofSuccess(contact);
    }

    @GetMapping("/getBusinessIntro1")
    @ApiOperation("业务介绍-投标保函")
    public ApiResponse getBusinessIntro1() {
        //TODO
        List<BusinessIntro1> businessIntro1 = preDao.businessIntro1List("投标保函");

        List<BusinessIntro2> businessIntro2 = new ArrayList<>();
        //TODO
        for (BusinessIntro2 bi2 : preDao.businessIntro2List("投标保函")){
            //TODO
            bi2.setImgM(preDao.businessIntro2Img(1));
            businessIntro2.add(bi2);
        }

        return ApiResponse.ofSuccess(new BusinessIntros(businessIntro1, businessIntro2));
    }

    @GetMapping("/getBusinessIntro2")
    @ApiOperation("业务介绍-履约保函")
    public ApiResponse getBusinessIntro2() {
        //TODO
        List<BusinessIntro1> businessIntro1 = preDao.businessIntro1List("履约保函");

        List<BusinessIntro2> businessIntro2 = new ArrayList<>();
        //TODO
        for (BusinessIntro2 bi2 : preDao.businessIntro2List("履约保函")){
            //TODO
            bi2.setImgM(preDao.businessIntro2Img(2));
            businessIntro2.add(bi2);
        }

        return ApiResponse.ofSuccess(new BusinessIntros(businessIntro1, businessIntro2));
    }

    @GetMapping("/getBusinessIntro3")
    @ApiOperation("业务介绍-质量(维修保修)保函")
    public ApiResponse getBusinessIntro3() {
        //TODO
        List<BusinessIntro1> businessIntro1 = preDao.businessIntro1List("质量(维修保修)保函");

        List<BusinessIntro2> businessIntro2 = new ArrayList<>();
        //TODO
        for (BusinessIntro2 bi2 : preDao.businessIntro2List("质量(维修保修)保函")){
            //TODO
            bi2.setImgM(preDao.businessIntro2Img(3));
            businessIntro2.add(bi2);
        }

        return ApiResponse.ofSuccess(new BusinessIntros(businessIntro1, businessIntro2));
    }

    @GetMapping("/getBusinessIntro4")
    @ApiOperation("业务介绍-预付款保函")
    public ApiResponse getBusinessIntro4() {
        //TODO
        List<BusinessIntro1> businessIntro1 = preDao.businessIntro1List("预付款保函");

        List<BusinessIntro2> businessIntro2 = new ArrayList<>();
        //TODO
        for (BusinessIntro2 bi2 : preDao.businessIntro2List("预付款保函")){
            //TODO
            bi2.setImgM(preDao.businessIntro2Img(4));
            businessIntro2.add(bi2);
        }

        return ApiResponse.ofSuccess(new BusinessIntros(businessIntro1, businessIntro2));
    }

    @GetMapping("/getBusinessIntro5")
    @ApiOperation("业务介绍-业主支付保函")
    public ApiResponse getBusinessIntro5() {
        //TODO
        List<BusinessIntro1> businessIntro1 = preDao.businessIntro1List("业主支付保函");

        List<BusinessIntro2> businessIntro2 = new ArrayList<>();
        //TODO
        for (BusinessIntro2 bi2 : preDao.businessIntro2List("业主支付保函")){
            //TODO
            bi2.setImgM(preDao.businessIntro2Img(5));
            businessIntro2.add(bi2);
        }

        return ApiResponse.ofSuccess(new BusinessIntros(businessIntro1, businessIntro2));
    }

    @GetMapping("/getBusinessIntro6")
    @ApiOperation("业务介绍-融资贷款担保")
    public ApiResponse getBusinessIntro6() {
        //TODO
        List<BusinessIntro1> businessIntro1 = preDao.businessIntro1List("融资贷款担保");

        List<BusinessIntro2> businessIntro2 = new ArrayList<>();
        //TODO
        for (BusinessIntro2 bi2 : preDao.businessIntro2List("海关关税保函")){
            //TODO
            bi2.setImgM(preDao.businessIntro2Img(6));
            businessIntro2.add(bi2);
        }

        return ApiResponse.ofSuccess(new BusinessIntros(businessIntro1, businessIntro2));
    }

    @GetMapping("/getBusinessIntro7")
    @ApiOperation("业务介绍-其他担保")
    public ApiResponse getBusinessIntro7() {
        //TODO
        List<BusinessIntro1> businessIntro1 = preDao.businessIntro1List("其他担保");

        List<BusinessIntro2> businessIntro2 = new ArrayList<>();
        //TODO
        for (BusinessIntro2 bi2 : preDao.businessIntro2List("境外保函")){
            //TODO
            bi2.setImgM(preDao.businessIntro2Img(7));
            businessIntro2.add(bi2);
        }

        return ApiResponse.ofSuccess(new BusinessIntros(businessIntro1, businessIntro2));
    }

    @GetMapping("/getBusinessIntro8")
    @ApiOperation("业务介绍-农民工工资保函")
    public ApiResponse getBusinessIntro8() {
        //TODO
        List<BusinessIntro1> businessIntro1 = preDao.businessIntro1List("农民工工资保函");

        List<BusinessIntro2> businessIntro2 = new ArrayList<>();
        //TODO
        for (BusinessIntro2 bi2 : preDao.businessIntro2List("农民工工资保函")){
            //TODO
            bi2.setImgM(preDao.businessIntro2Img(8));
            businessIntro2.add(bi2);
        }
        return ApiResponse.ofSuccess(new BusinessIntros(businessIntro1, businessIntro2));
    }

    @GetMapping("/getNews")
    @ApiOperation("新闻")
    public ApiResponse getNews() {
        //TODO
        String isTrue = preDao.findNewsSwitch("企业新闻");
        //TODO
        List<News> news = preDao.newsList("行业新闻");
        //TODO
        String switchs = preDao.findNewsSwitch("企业新闻");

        /*客户问答模块*/
        List<News> qus = preDao.qusList();
        //TODO
        if ("true".equals(isTrue)) {
            List<News> news2 = preDao.newsList("企业新闻");
            return ApiResponse.ofSuccess(new NewsInterface(switchs, news, news2, qus));
        } else {
            return ApiResponse.ofSuccess(new NewsInterface(switchs, news, qus));
        }
    }

    @GetMapping("/getNewsDetail")
    @ApiOperation("新闻-详情")
    public ApiResponse getNewsDetail(@RequestParam Integer id) {
        List<NewsDetail> news = preDao.detailList(id);
        return ApiResponse.ofSuccess(news);
    }

    @GetMapping("/getLOIFind")
    @ApiOperation("保函查询")
    public ApiResponse getLOIFind(@RequestParam String loiId) {

        List<LOIFind> loiFindList = preDao.loiFindList(loiId);
        List<EmptyLOIName> projectName = new ArrayList<>();
        try {
            if (StringUtils.isEmpty(loiFindList.get(0))) {
                projectName.add(new EmptyLOIName("查无此项目",null, null));
                String[] str = {"nothing.jpg"};
                //TODO
                return ApiResponse.ofSuccess(new EmptyLOI(projectName, str));
            }
        } catch (Exception e) {
            projectName.add(new EmptyLOIName("查无此项目", null, null));
            String[] str = {"nothing.jpg"};
            //TODO
            return ApiResponse.ofSuccess(new EmptyLOI(projectName, str));
        }

        if ("true".equals(preDao.loiFindIsTrue(loiId))) {
            //若为非true则传图片
            if (!"true".equals(preDao.loiFindSwitchs(loiId))) {
                String[] loiPics = preDao.loiFindPic(loiId);
                List<LOIFindVO> loiFindVOList = preDao.loiFindVOList(loiId);
                return ApiResponse.ofSuccess(new LoisVO(loiFindVOList, loiPics));
            }
            //否则传文本
            else {
                return ApiResponse.ofSuccess(new LOIs(loiFindList, null));
            }
        } else {
            List<LOIFindVO> loiFindVOList = preDao.loiFindVOList(loiId);
            return ApiResponse.ofSuccess(new LoisVO(loiFindVOList, null));
        }
    }


    @ApiOperation("各种轮播")
    @GetMapping("/getRotation")
    public ApiResponse getRotation(
            @ApiParam("1:首页轮播 2:企业简介 3:新闻动态 " +
                    "4:合作银行 5:保函查询 6:联系我们 7:页脚图片 8:企业文化")
            @RequestParam("type") int type) throws IOException {

        // 获取图片数组
        String[] getImage = preService.getImageUrls(type);
        // 用于存储切割的图片
        String[][] cutImages = new String[getImage.length][4];
        // 用于存储切完的图片
        Map<String, String[][]> imagesMap = new HashMap<>();
        // 输出小图
        for (int i = 0, size = getImage.length; i < size; i++) {
            String originalImg = getImage[i];
            String[] cutImage = {
                    originalImg.substring(0, originalImg.lastIndexOf(".")),
                    originalImg.substring(originalImg.lastIndexOf(".") + 1)
            };
            //TODO
            for (int j = 0, jSize = cutImages[i].length; j < jSize; j++) {
                cutImages[i][j] = cutImage[0] + j + "." + cutImage[1];
            }
        }
        imagesMap.put("img", cutImages);

        return ApiResponse.ofSuccess(imagesMap);
    }

    @GetMapping("/getFileUpload")
    @ApiOperation("文件下载")
    public ApiResponse getFileUpload() {

        String[] fileName = preDao.findFileName();

        return ApiResponse.ofSuccess(ImageAdapter.fileList(fileName));
    }

    @ApplyCheckIP
    @PostMapping("/uploadUserIntro")
    @ApiOperation("申请办理")
    public ApiResponse uploadUserIntro(@RequestBody Map<String, Object> jsonData) {

        String themeOfMail = "";
        String contentOfMail = "";

        String typeId;
        String applicantTel;
        String applicantEmail;
        String applicantName;
        String term;
        String guaranteeSum;
        String projectName;
        try {
            typeId = jsonData.get("typeId").toString();
            applicantTel = jsonData.get("applicantTel").toString();
            applicantEmail = jsonData.get("applicantEmail").toString();
            applicantName = jsonData.get("applicantName").toString();
            term = jsonData.get("term").toString();
            guaranteeSum = jsonData.get("guaranteeSum").toString();
            projectName = jsonData.get("projectName").toString();
        } catch (Exception e) {
            return ApiResponse.ofError(ApiResponse.Status.APPLY_SUBMIT_ERROR);
        }
        //TODO
        if ("1".equals(typeId)) {
            CompanyLgFind companyLgFind = new CompanyLgFind();
            try {
                String types = jsonData.get("types").toString();
                companyLgFind.setTypeId(new Integer(typeId));
                companyLgFind.setTypes(types);
                companyLgFind.setProjectName(projectName);
                companyLgFind.setTerm(term);
                companyLgFind.setGuaranteeSum(new BigDecimal(guaranteeSum));
                companyLgFind.setApplicantTel(applicantTel);
                companyLgFind.setApplicantEmail(applicantEmail);
                companyLgFind.setApplicantName(applicantName);
            } catch (Exception e) {
                return ApiResponse.ofError(ApiResponse.Status.APPLY_SUBMIT_ERROR);
            }
            try {
                preDao.companyLgFindInsert(companyLgFind);
                //TODO
                themeOfMail = "商业保函";
                contentOfMail = MailContent.contentOfMailFor1(companyLgFind);
            } catch (Exception e) {
                return ApiResponse.ofError(ApiResponse.Status.APPLY_INSERT_ERROR);
            }
        } else {
            String bankLg;
            String nature;
            String aQualification;
            String equirement;
            try {
                bankLg = jsonData.get("bankLg").toString();
                nature = jsonData.get("nature").toString();
                aQualification = jsonData.get("aQualification").toString();
                equirement = jsonData.get("equirement").toString();
            } catch (Exception e) {
                return ApiResponse.ofError(ApiResponse.Status.APPLY_SUBMIT_ERROR);
            }
            if ("2".equals(typeId)) {
                BankLgFindPurchase bankLgFindPurchase = new BankLgFindPurchase();
                bankLgFindPurchase.setApplicantEmail(applicantEmail);
                bankLgFindPurchase.setApplicantName(applicantName);
                bankLgFindPurchase.setApplicantTel(applicantTel);
                bankLgFindPurchase.setAQualification(aQualification);
                bankLgFindPurchase.setBankLg(bankLg);
                bankLgFindPurchase.setEquirement(equirement);
                bankLgFindPurchase.setGuaranteeSum(new BigDecimal(guaranteeSum));
                bankLgFindPurchase.setNature(nature);
                bankLgFindPurchase.setProjectName(projectName);
                bankLgFindPurchase.setTerm(term);
                bankLgFindPurchase.setTypeId(new Integer(typeId));
                try {
                    preDao.bankLgFindPurchaseInsert(bankLgFindPurchase);
                    //TODO
                    themeOfMail = "货物服务类保函";
                    contentOfMail = MailContent.contentOfMailFor2(bankLgFindPurchase);
                } catch (Exception e) {
                    return ApiResponse.ofError(ApiResponse.Status.APPLY_INSERT_ERROR);
                }
            } else {
                BankLgFindEngineering bankLgFindEngineering = new BankLgFindEngineering();
                String qualification;
                String grade;
                try {
                    qualification = jsonData.get("qualification").toString();
                    grade = jsonData.get("grade").toString();
                } catch (Exception e) {
                    return ApiResponse.ofError(ApiResponse.Status.APPLY_SUBMIT_ERROR);
                }
                bankLgFindEngineering.setApplicantEmail(applicantEmail);
                bankLgFindEngineering.setApplicantName(applicantName);
                bankLgFindEngineering.setApplicantTel(applicantTel);
                bankLgFindEngineering.setAQualification(aQualification);
                bankLgFindEngineering.setBankLg(bankLg);
                bankLgFindEngineering.setEquirement(equirement);
                bankLgFindEngineering.setGrade(grade);
                bankLgFindEngineering.setGuaranteeSum(new BigDecimal(guaranteeSum));
                bankLgFindEngineering.setNature(nature);
                bankLgFindEngineering.setProjectName(projectName);
                bankLgFindEngineering.setQualification(qualification);
                bankLgFindEngineering.setTerm(term);
                bankLgFindEngineering.setTypeId(new Integer(typeId));

                try {
                    preDao.bankLgFindEngineeringInsert(bankLgFindEngineering);
                    //TODO
                    themeOfMail = "工程类保函";
                    contentOfMail = MailContent.contentOfMailFor3(bankLgFindEngineering);
                } catch (Exception e) {
                    return ApiResponse.ofError(ApiResponse.Status.APPLY_INSERT_ERROR);
                }
            }
        }

        Subscriber subscriber = preDao.findMailIntro();
        mailService.sendSimpleMail(
                subscriber.getSubscriberMailHost().trim(),
                subscriber.getSubscriberMail().trim(),
                subscriber.getSubscriberMailPassword().trim(),
                subscriber.getSubscriberMail().trim(),
                MailConstant.THEME + themeOfMail,
                contentOfMail
        );
        return ApiResponse.ofSuccess("提交成功");
    }
}
