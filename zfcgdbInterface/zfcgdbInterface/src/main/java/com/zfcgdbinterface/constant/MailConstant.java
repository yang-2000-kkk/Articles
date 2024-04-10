package com.zfcgdbinterface.constant;

/**
 * @author zht
 * @date 2019/7/14 7:38
 **/
public interface MailConstant {

    String THEME = "用户提交申请-";

    String CONTENT_PREFIX = "【广东履约信用担保股份有限公司】用户提交了申请办理，";

    String CONTENT_SUFFIX = "，请尽快处理！";

    /**
     * 设置邮箱验证码30分钟有效期
     */
    Integer VALIDITY = 1800000;

    /**
     * 定义可以重新发送验证码的时间
     */
    int RETRY_VERITYCODE_TIME = 60000;
}
