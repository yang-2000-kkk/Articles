package com.zfcgdbinterface.service;

import com.zfcgdbinterface.adapter.ImageAdapter;
import com.zfcgdbinterface.dao.PreDao;
import com.zfcgdbinterface.po.rotation.RotationType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zht
 * @date 2019/7/18 19:06
 **/
@Service
public class PreService {

    @Resource
    private PreDao preDao;

    /**
     * 遍历轮播图片类型
     */
    private RotationType getRotationType(int type){
        for (RotationType value : RotationType.values()) {
            if(value.getType() == type){
                return value;
            }
        }
        return null;
    }

    private String[] getImageUrls(RotationType rotationType) {
        String[] imageByType = preDao.findImageByType(rotationType.getType());
        return ImageAdapter.imageList(imageByType);
    }

    public String[] getImageUrls(int type) {
        RotationType rotationType = getRotationType(type);
        return getImageUrls(rotationType);
    }
}
