package com.zfcgdbinterface.po;

import lombok.Getter;
import lombok.Setter;

/**
 * 联系我们
 *
 * @author zht
 * @date 2019/7/19 9:38
 **/
@Getter
@Setter
public class Contact {

    private String companyName;

    private String address;

    private String postalCode;

    private String tel;

    private String mail;

    private String subwayMode;

    private String busMode;
}
