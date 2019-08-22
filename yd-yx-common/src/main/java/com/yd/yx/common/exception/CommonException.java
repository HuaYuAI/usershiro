package com.yd.yx.common.exception;

import org.apache.commons.lang3.StringUtils;
/**
 * Created by huayu on 2019/8/20.
 */
public class CommonException extends BaseException {

    public CommonException(String code) {
        super(code, (String) null, (Object[]) null, (Throwable) null);
    }

    public CommonException(String code, String message) {
        super(code, message, (Object[]) null, (Throwable) null);
    }

    public CommonException(String code, Object[] values) {
        super(code, null, values, null);
    }

    public CommonException(String code, String message, Object[] values) {
        super(code, message, values, (Throwable) null);
    }

    public CommonException(String code, String message, Object[] values, Throwable cause) {
        super(code, message, values, cause);
    }

    public String getErrorCode() {
        String errorCode = "00099";
        String message = this.getMessage() == null ? this.getCode() : this.getMessage();
        if (!StringUtils.isEmpty(message)) {
            String[] messageValues = StringUtils.split(message, ":");
            if (messageValues.length > 1) {
                errorCode = messageValues[0];
            }
        }

        return errorCode;
    }

}
