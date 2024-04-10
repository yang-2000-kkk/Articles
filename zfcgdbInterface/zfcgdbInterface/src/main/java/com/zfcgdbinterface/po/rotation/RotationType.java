package com.zfcgdbinterface.po.rotation;

/**
 * @author zht
 **/
public enum RotationType {

    /**
     * TODO
     */
    HOME("首页", 1),
    BUSINESS("企业简介", 2),
    NEWSDYNAMIC("新闻动态", 3),
    COOPERATIONBANK("合作银行", 4),
    LOIFIND("保函查询", 5),
    CONTACT("联系我们", 6),
    FOOTPIC("页脚图片", 7),
    BUSINESSCUL("企业文化", 8),
    ;

    private String name;

    private int type;

    RotationType(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
