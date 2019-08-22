package com.yd.yx.common.dto;

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
