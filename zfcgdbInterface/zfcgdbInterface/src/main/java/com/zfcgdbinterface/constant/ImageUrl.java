package com.zfcgdbinterface.constant;

/**
 * @author zht
 **/
public class ImageUrl {

    /**
     * 文件/图片存放地址
     * TODO 47.100.238.217
     */
    private final static String URL = "http://120.79.197.110:8080/zfcgdbInterface/file/";

    public static String getImgUrl(String imgName){
        return URL + imgName;
    }

    public static String getFileUrl(String imgName){
        return URL + "file/" + imgName;
    }
}
