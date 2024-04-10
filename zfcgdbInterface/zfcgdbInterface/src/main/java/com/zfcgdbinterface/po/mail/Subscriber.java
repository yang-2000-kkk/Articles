package com.zfcgdbinterface.po.mail;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户表
 * @author zht
 */
@Getter
@Setter
public class Subscriber {

    /**
     * 邮箱
     */
    private String subscriberMail;

    /**
     * 邮箱授权码
     */
    private String subscriberMailPassword;

    /**
     * 邮箱服务器地址
     */
    private String subscriberMailHost;
}