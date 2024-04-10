package com.zfcgdbinterface.po.news;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zht
 * @date 2019/7/22 9:44
 **/
@Getter
@Setter
public class NewsDetail {

    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 正文
     */
    private String pra;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date newsTime;
}
