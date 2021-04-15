package com.yd.yx.userclient.api.dto.user.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by huayu on 2019/8/19.
 */
@Data
public class RegisteredUserMessageRequestDTO extends LoginUserMessageRequestDTO implements Serializable {

    private String phone;

    private String birthday;

    private Integer sex;

}
