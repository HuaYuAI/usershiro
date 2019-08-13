package com.huayu.shiro.api.user.abs;

/**
 * Created by huayu on 2019/7/13.
 */
public enum  ResponseCodeEnum {
    SYSTEM_BUY("0111","系统异常");
    private String code;
    private String msd;

    ResponseCodeEnum(String code, String msd) {
        this.code = code;
        this.msd = msd;
    }
}
