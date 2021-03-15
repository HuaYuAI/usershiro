package com.yd.yx.common.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName
 * @Description:
 * @Author:
 * @Date:
 **/
@Data
public class BaseException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = 3690050198402075828L;

    private String code;
    private String message;
    private Throwable throwable;
    private Object[] values;

    private BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.code = code;
    }

    public BaseException(String code, String message, Object[] values, Throwable cause) {
        this(code, message, cause);
        this.values = values;
    }



}
