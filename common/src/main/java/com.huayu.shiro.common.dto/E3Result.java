package com.huayu.shiro.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by HuaYu on 2018/2/18.
 */
@ApiModel(value="E3Result",description="返回类型")
public class E3Result implements Serializable {

    @ApiModelProperty(value="状态",name="status")
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static E3Result build(Integer status, String msg, Object data) {
        return new E3Result(status, msg, data);
    }

    public static E3Result ok(Object data) {
        return new E3Result(data);
    }

    public static E3Result ok() {
        return new E3Result(null);
    }

    public E3Result() {

    }

    public static E3Result build(Integer status, String msg) {
        return new E3Result(status, msg, null);
    }

    public E3Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public E3Result(Object data){
        this.status = 200;
        this.msg = "OK";
        this.data = data;
/*        InputStream inputStream = new URL("").openStream();
        Properties properties = new Properties();
        properties.load(inputStream);*/
    }

//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
