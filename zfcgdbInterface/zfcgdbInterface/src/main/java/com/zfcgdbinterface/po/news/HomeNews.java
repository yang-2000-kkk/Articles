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
public class HomeNews {

    private Integer id;
    /**
     * 标题
     */
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date newsTime;
}
