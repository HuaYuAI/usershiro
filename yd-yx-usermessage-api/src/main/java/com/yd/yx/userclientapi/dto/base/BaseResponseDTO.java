package com.yd.yx.userclientapi.dto.base;

import lombok.Data;
/**
 * Created by huayu on 2019/8/18.
 */
@Data
public class BaseResponseDTO<T> {

    private String code;

    private String msgCode;

    private String msg;

    private T data;

}
