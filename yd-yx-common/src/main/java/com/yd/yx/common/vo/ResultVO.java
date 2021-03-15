package com.yd.yx.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName
 * @Description:
 * @Author:
 * @Date:
 **/
@ApiModel(
        description = "返回结果"
)
@Data
public class ResultVO<T> {

    @ApiModelProperty(value = "状态")
    private String code;
//
//    @ApiModelProperty(value = "信息")
//    private String msgCode;

    @ApiModelProperty(value = "信息")
    private String msg;

    @ApiModelProperty(value = "返回结果")
    private T data;

}
