package com.zfcgdbinterface.po.home;

import com.zfcgdbinterface.adapter.ImageAdapter;
import com.zfcgdbinterface.po.Home;
import com.zfcgdbinterface.po.news.HomeNews;
import com.zfcgdbinterface.po.news.News;
import com.zfcgdbinterface.po.news.Qus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zht
 * @date 2019/7/19 8:50
 **/
@Getter
@Setter
public class Homes {

    private List<Home> home;

    private String[] imgs;

    private List<HomeNews> news;

    /**客户问答模块*/
    private List<Qus> item;

    public Homes(List<Home> home, String[] imgs, List<HomeNews> news, List<Qus> item) {
        this.home = home;
        this.imgs = ImageAdapter.imageList(imgs);
        this.news = news;
        this.item = item;
    }
}
