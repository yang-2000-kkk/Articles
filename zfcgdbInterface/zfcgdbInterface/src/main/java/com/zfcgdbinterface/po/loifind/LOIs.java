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
public class LOIs {

    private List<LOIFind> loiFind;

    private String[] pic;

    public LOIs(List<LOIFind> loiFind, String[] pic) {
        this.loiFind = loiFind;
        if (StringUtils.isEmpty(pic)) {
            this.pic = pic;
        } else {
            this.pic = ImageAdapter.imageList(pic);
        }

    }
}
