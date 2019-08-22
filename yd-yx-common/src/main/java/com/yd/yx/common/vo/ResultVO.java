package com.yd.yx.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * Created by huayu on 2019/8/20.
 */



/**
 * @author 昱升
 * @version 创建时间：2018年7月29日 下午3:25:02
 * 结果对象
 */
@ApiModel(
        description = "返回结果"
)
@Data
public class ResultVO<T> {

    @ApiModelProperty(value = "状态")
    private String code;

    @ApiModelProperty(value = "信息")
    private String msgCode;

    @ApiModelProperty(value = "信息")
    private String msg;

    @ApiModelProperty(value = "返回结果")
    private T data;

}
