package com.yd.yx.userclientapi.dto.user.request;

import com.yd.yx.common.dto.BaseRequestDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by huayu on 2019/8/18.
 */
@Data
public class LoginUserMessageRequestDTO extends BaseRequestDTO implements Serializable {

    private String userName;

    private String password;

}
