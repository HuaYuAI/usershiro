package com.huayu.shiro.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by huayu on 2019/1/6.
 */
@ApiModel(value="ResultMessage",description="返回类型")
@Data
public class CommonResultMessage <T> {

    @ApiModelProperty(value="状态信息",name="status")
    private String status;

    @ApiModelProperty(value="状态码",name="code")
    private Integer code;

    @ApiModelProperty(value="错误信息",name="msg")
    private String msg;

    @ApiModelProperty(value="相应消息",name="data")
    private T data;


}
