package com.zfcgdbinterface.po.rotation;

import com.zfcgdbinterface.constant.ImageUrl;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zht
 **/
@Getter
@Setter
public class RotationImage {

    private String imgUrl;

    private Date time;

    public void setImgUrl(String imgUrl) {
        this.imgUrl = ImageUrl.getImgUrl(imgUrl);
    }
}
