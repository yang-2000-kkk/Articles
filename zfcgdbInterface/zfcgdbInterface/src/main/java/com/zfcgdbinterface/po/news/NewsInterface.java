package com.zfcgdbinterface.po.news;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zht
 * @date 2019/7/22 9:50
 **/
@Getter
@Setter
public class NewsInterface {

    /**
     * 若为false，则不显示‘企业新闻’到首页
     */
    private String newsSwitch;

    private List<News> industry;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<News> company;

    private List<News> qus;

    public NewsInterface(String newsSwitch, List<News> industry, List<News> qus) {
        this.newsSwitch = newsSwitch;
        this.industry = industry;
        this.qus = qus;
    }

    public NewsInterface(String newsSwitch, List<News> industry, List<News> company, List<News> qus) {
        this.newsSwitch = newsSwitch;
        this.industry = industry;
        this.company = company;
        this.qus = qus;
    }
}