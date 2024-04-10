package com.zfcgdbinterface.adapter;

import com.zfcgdbinterface.constant.ImageUrl;

/**
 * @author zht
 **/
public class ImageAdapter {

    public static String[] imageList(String[] images){
        String[] imgs = new String[images.length];
        for (int i = 0; i < images.length; i++) {
            imgs[i] = ImageUrl.getImgUrl(images[i]);
        }
        return imgs;
    }

    public static String[] fileList(String[] images){
        String[] imgs = new String[images.length];
        for (int i = 0; i < images.length; i++) {
            imgs[i] = ImageUrl.getFileUrl(images[i]);
        }
        return imgs;
    }

}
