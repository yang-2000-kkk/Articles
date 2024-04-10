package com.zfcgdbinterface.po;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zfcgdbinterface.constant.ImageUrl;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zht
 * @date 2019/7/18 20:37
 **/
@Getter
@Setter
public class Home {

    /**
     * 内容
     */
    private String content;

    /**
     * 图片地址
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String img;

    public void setImg(String img) {
        this.img = ImageUrl.getImgUrl(img);
    }
}
