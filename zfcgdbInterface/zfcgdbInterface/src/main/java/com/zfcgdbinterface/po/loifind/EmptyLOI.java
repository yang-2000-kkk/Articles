package com.zfcgdbinterface.po.loifind;

import com.zfcgdbinterface.adapter.ImageAdapter;
import com.zfcgdbinterface.constant.ImageUrl;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zht
 * @date 2019/7/23 11:58
 **/
@Getter
@Setter
public class EmptyLOI {

    private List<EmptyLOIName> loiFind;

    private String[] pic;

    public EmptyLOI(List<EmptyLOIName> loiFind, String[] pic) {
        this.loiFind = loiFind;
        this.pic = ImageAdapter.imageList(pic);
    }
}
