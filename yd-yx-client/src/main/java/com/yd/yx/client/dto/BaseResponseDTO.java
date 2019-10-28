package com.yd.yx.client.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by huayu on 2019/8/18.
 */
@Data
// @Accessors(chain = true)
public class BaseResponseDTO<T> {


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

    /**
     * 构造失败数据
     */
    public static <T> BaseResponseDTO<T> createFailResult(String errorCode, String errorMsg) {
        BaseResponseDTO<T> result = new BaseResponseDTO<>();
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
