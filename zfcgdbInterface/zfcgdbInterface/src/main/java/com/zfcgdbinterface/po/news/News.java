package com.zfcgdbinterface.po.news;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zht
 * @date 2019/7/21 17:41
 **/
@Getter
@Setter
public class News {

    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 概括
     */
    private String generalize;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date newsTime;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", generalize='" + generalize + '\'' +
                ", newsTime=" + newsTime +
                '}';
    }
}
