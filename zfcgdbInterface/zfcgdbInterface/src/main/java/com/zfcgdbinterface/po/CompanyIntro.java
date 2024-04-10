package com.zfcgdbinterface.po;

import com.zfcgdbinterface.constant.ImageUrl;
import lombok.Getter;
import lombok.Setter;

/**
 * 公司简介
 * @author zht
 * @date 2019/7/18 15:00
 **/
@Getter
@Setter
public class CompanyIntro {

    /**
     * 类型
     */
    private String companyType;

    /**
     * 标题
     */
    private String title;

    /**
     * 段落
     */
    private String titlePra;

    /**
     * 图片
     */
    private String titleImages;

    public void setTitleImages(String titleImages) {
        this.titleImages = ImageUrl.getImgUrl(titleImages);
    }
}
