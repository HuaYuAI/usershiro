package com.yd.yx.userservice.utils.jwt;

import lombok.Data;

/**
 * Created by huayu on 2019/9/8.
 */
@Data
public class JwtInfo {

    private String uid;

    public JwtInfo() {
    }

    public JwtInfo(String uid) {
        this.uid = uid;
    }
}
