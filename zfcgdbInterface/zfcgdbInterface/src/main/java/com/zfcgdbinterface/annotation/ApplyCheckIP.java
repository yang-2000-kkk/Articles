package com.zfcgdbinterface.annotation;

import java.lang.annotation.*;

/**
 * 检查提交IP问题
 * @author zht
 * @date 2019/7/27 10:30
 **/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApplyCheckIP {

    /**
     * 该注解作用于方法上时需要备注信息
     */
    boolean isCheck() default true;
}
