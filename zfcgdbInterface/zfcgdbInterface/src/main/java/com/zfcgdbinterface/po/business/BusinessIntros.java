package com.zfcgdbinterface.po.business;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zht
 * @date 2019/7/21 9:39
 **/
@Getter
@Setter
public class BusinessIntros {

    private List<BusinessIntro1> businessIntro1List;

    private List<BusinessIntro2> businessIntro2List;

    public BusinessIntros(List<BusinessIntro1> businessIntro1List, List<BusinessIntro2> businessIntro2List) {
        this.businessIntro1List = businessIntro1List;
        this.businessIntro2List = businessIntro2List;
    }
}
