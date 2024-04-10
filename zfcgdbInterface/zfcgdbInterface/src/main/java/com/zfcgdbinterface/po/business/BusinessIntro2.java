package com.zfcgdbinterface.po.business;

import com.zfcgdbinterface.adapter.ImageAdapter;
import com.zfcgdbinterface.constant.ImageUrl;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zht
 * @date 2019/7/21 9:20
 **/
@Getter
@Setter
public class BusinessIntro2 {

    /**
     * 标题
     */
    private String titleC;

    /**
     * 段落1
     */
    private String qus01;

    /**
     * 段落2
     */
    private String qus02;

    /**
     * 图片
     */
    private String imgP;

    /**
     * 扫描图
     */
    private String[] imgM;

    public void setImgP(String imgP) {
        this.imgP = ImageUrl.getImgUrl(imgP);
    }

    public void setImgM(String[] imgM) {
        this.imgM = ImageAdapter.imageList(imgM);
    }
}
