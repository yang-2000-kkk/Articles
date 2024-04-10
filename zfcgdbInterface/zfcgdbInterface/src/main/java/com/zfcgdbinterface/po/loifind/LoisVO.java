package com.zfcgdbinterface.po.loifind;

import com.zfcgdbinterface.adapter.ImageAdapter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author zht
 * @date 2019/7/22 16:29
 **/
@Getter
@Setter
public class LoisVO {

    private List<LOIFindVO> loiFind;

    private String[] pic;

    public LoisVO(List<LOIFindVO> loiFind, String[] pic) {
        this.loiFind = loiFind;
        if (StringUtils.isEmpty(pic)) {
            this.pic = pic;
        } else {
            this.pic = ImageAdapter.imageList(pic);
        }

    }
}
