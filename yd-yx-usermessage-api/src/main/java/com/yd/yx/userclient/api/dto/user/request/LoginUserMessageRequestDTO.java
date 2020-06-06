package com.yd.yx.userclient.api.dto.user.request;

import com.yd.yx.client.dto.BaseRequestDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by huayu on 2019/8/18.
 */
@Data
public class LoginUserMessageRequestDTO extends BaseRequestDTO implements Serializable {

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String captcha;

}
