package com.zfcgdbinterface.po.news;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 客户问答模块
 * @author zht
 * @date 2019/7/21 17:41
 **/
@Getter
@Setter
public class Qus {

    private Integer id;

    /**
     * 问题
     */
    private String qus;

    /**
     * 答案
     */
    private String ans;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + qus + '\'' +
                ", generalize='" + ans + '\'' +
                '}';
    }
}
