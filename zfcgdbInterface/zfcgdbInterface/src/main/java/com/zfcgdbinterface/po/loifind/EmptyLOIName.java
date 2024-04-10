package com.zfcgdbinterface.po.loifind;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zht
 * @date 2019/7/24 20:18
 **/
@Getter
@Setter
public class EmptyLOIName {

    private String projectName;

    private String displayText;

    private String switchs;

    public EmptyLOIName(String projectName, String displayText, String switchs) {
        this.projectName = projectName;
        this.displayText = displayText;
        this.switchs = switchs;
    }
}
