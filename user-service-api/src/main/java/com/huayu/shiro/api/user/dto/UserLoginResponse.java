package com.huayu.shiro.api.user.dto;

import com.huayu.shiro.api.user.abs.AbstractResponse;

import java.io.Serializable;

/**
 * Created by huayu on 2019/7/13.
 */
public class UserLoginResponse extends AbstractResponse implements Serializable {

    private static final long serialVersionUID = 1985669069833588251L;

    private Integer uid;

    private String avatar;

}
