package com.yd.yx.client.dto;

import java.io.Serializable;

public class BaseResponseDTO<T> implements Serializable {


    private static final long serialVersionUID = -6932655599075823778L;
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 唯一请求id
     */
    private String requestId;

    /** HTTP 状态 */
    private Integer httpStatusCode;

    /** 动态错误吗 */
    private String dynamicCode;

    /** 动态错误消息 */
    private String dynamicMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getDynamicCode() {
        return dynamicCode;
    }

    public void setDynamicCode(String dynamicCode) {
        this.dynamicCode = dynamicCode;
    }

    public String getDynamicMessage() {
        return dynamicMessage;
    }

    public void setDynamicMessage(String dynamicMessage) {
        this.dynamicMessage = dynamicMessage;
    }

    /**
     * 构造失败数据
     */
    public static <T> BaseResponseDTO<T> createFailResult(String errorCode, String errorMsg) {
        BaseResponseDTO<T> result = new BaseResponseDTO<T>();
        result.setSuccess(false);
        result.setCode(errorCode);
        result.setMessage(errorMsg);
        result.setHttpStatusCode(400);
        return result;
    }

    /**
     * 构建成功数据
     */
    public static <T> BaseResponseDTO<T> createSuccessResult(T data) {
        BaseResponseDTO<T> result = new BaseResponseDTO<T>();
        result.setSuccess(true);
        result.setData(data);
        result.setHttpStatusCode(200);
        return result;
    }

    /**
     * 构造无数据返回操作类的成功请求
     */
    public static BaseResponseDTO createSuccessResult() {
        return createSuccessResult(null);
    }

}
