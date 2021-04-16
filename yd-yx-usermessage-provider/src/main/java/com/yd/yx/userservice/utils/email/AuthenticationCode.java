package com.yd.yx.userservice.utils.email;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class AuthenticationCode implements Serializable {

    private String code;

    private LocalDateTime expireTime;

    public AuthenticationCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public AuthenticationCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }

}
