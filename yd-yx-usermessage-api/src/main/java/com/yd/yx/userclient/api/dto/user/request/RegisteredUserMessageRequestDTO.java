package com.yd.yx.userclient.api.dto.user.request;

import com.yd.yx.client.dto.BaseRequestDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by huayu on 2019/8/19.
 */
@Data
public class RegisteredUserMessageRequestDTO  extends BaseRequestDTO implements Serializable {

    private String username;

    private String password;



}
