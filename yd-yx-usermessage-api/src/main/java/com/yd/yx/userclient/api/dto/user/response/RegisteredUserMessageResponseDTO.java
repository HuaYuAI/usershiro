package com.yd.yx.userclient.api.dto.user.response;

import lombok.Data;

/**
 * Created by huayu on 2019/8/20.
 */
@Data
public class RegisteredUserMessageResponseDTO {

    private String token;

    public RegisteredUserMessageResponseDTO(String token) {
        this.token = token;
    }
}
