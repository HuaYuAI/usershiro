package com.yd.yx.userservice.constant;

/**
 * Created by huayu on 2019/8/20.
 */
public enum  UserStatusEnum {
    USER_MESSAGE(0,"普通用户"),
    USER_WHITE(2,"白名单用户"),
    USER_BLACK(3,"黑名单用户")
    ;

    private Integer status;

    private String message;

    UserStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
