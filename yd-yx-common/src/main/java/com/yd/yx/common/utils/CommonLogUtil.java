package com.yd.yx.common.utils;

import com.yd.yx.common.dto.BaseResponseDTO;
import com.yd.yx.common.exception.CommonException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
/**
 * Created by huayu on 2019/8/22.
 */
public class CommonLogUtil {

    protected CommonLogUtil() {
    }

    public static void printBeginLog(Logger logger, String className, String methodName) {
        if (logger.isInfoEnabled()) {
            logger.info(buildBeginEngLog(className, methodName, "BEGIN..."));
        }
    }

    public static void printBeginLog(Logger logger, String className, String methodName, String params) {
        if (logger.isInfoEnabled()) {
            logger.info(buildBeginEndLog(className, methodName, params,"BEGIN..."));
        }
    }

    public static void printEndLog(Logger logger, String className, String methodName, String ret) {
        if (logger.isInfoEnabled()) {
            logger.info(buildBeginEndLog(className, methodName, ret, "END..."));
        }
    }

    public static void printEndLog(Logger logger, String className, String methodName, String ret, Long timeConsumed) {
        if (logger.isInfoEnabled()) {
            logger.info(buildBeginEndLog(className, methodName, ret, "END...  ".concat(timeConsumed+" ms")));
        }
    }

    public static void printEndLog(Logger logger, String className, String methodName) {
        if (logger.isInfoEnabled()) {
            logger.info(buildBeginEngLog(className, methodName, "END..."));
        }
    }

    private static String buildBeginEngLog(String className, String methodName, String str) {
        return new StringBuilder().append(className).append("::").append(methodName).append(":").append(str).toString();
    }

    private static String buildBeginEndLog(String className, String methodName, String params, String str) {
        return new StringBuilder().append(className).append("::").append(methodName).append("::").append(str).append("\n").append(params).toString();
    }

    public static void printAndThrowErrorException(Logger logger, String className, String methodName, String errorCode,
                                                   String errorMsg, Exception e) throws CommonException {
        if (logger.isErrorEnabled()) {
            logger.error(new StringBuilder().append(className).append("::").append(methodName).append(":").append("[")
                    .append(StringUtils.trimToEmpty(errorCode)).append(" ")
                    .append((e != null ? e.toString() : StringUtils.trimToEmpty(errorMsg))).toString());
        }

        StringBuilder eSb = new StringBuilder().append(e != null ? e.getMessage() : errorMsg);

        throw new CommonException(errorCode, eSb.toString(), new String[] { eSb.toString() }, e);
    }

    public static void printAndThrowErrorException(Logger logger, String className, String methodName, String errorCode)
            throws CommonException {
        if (logger.isErrorEnabled()) {
            logger.error(new StringBuilder().append(className).append("::").append(methodName).append(":")
                    .append(StringUtils.trimToEmpty(errorCode)).toString());
        }
        throw new CommonException(errorCode);
    }

    public static void printAndThrowErrorExceptionWithParams(Logger logger, String className,
                                                             String methodName, String errorCode, String errorMsg, Exception e, Object[] values)
            throws CommonException {
        if (logger.isErrorEnabled()) {
            logger.error(new StringBuilder().append(className).append("::").append(methodName).append(":").append("[")
                    .append(StringUtils.trimToEmpty(errorCode)).append(" ")
                    .append((e != null ? e.toString() : StringUtils.trimToEmpty(errorMsg))).toString());
        }
        throw new CommonException(errorCode, values);
    }

    public static void printAndThrowErrorExceptionWithParams(Logger logger, String className, String methodName, String errorCode, Object[] values)
            throws CommonException {
        if (logger.isErrorEnabled()) {
            logger.error(new StringBuilder().append(className).append("::").append(methodName).append(":")
                    .append(StringUtils.trimToEmpty(errorCode)).toString());
        }
        throw new CommonException(errorCode, values);
    }

    // 打 Info 日志
    public static void printInfoLog(Logger logger, String className, String methodName, String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(new StringBuilder().append(className).append("::").append(methodName).append(":").append(msg)
                    .toString());
        }
    }

    // 打 Debug 日志
    public static void printDebugLog(Logger logger, String className, String methodName, String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuilder().append(className).append("::").append(methodName).append(":").append(msg)
                    .toString());
        }
    }

    public static void printWarnLog(Logger logger, String className, String methodName, String errorCode,
                                    String errorMsg, Exception e) {
        if (logger.isWarnEnabled()) {
            logger.warn(buildWarnErrorLog(className, methodName, errorCode, errorMsg, e));
        }
    }

    public static void printErrorLog(Logger logger, String className, String methodName, String errorCode,
                                     String errorMsg, Exception e) {
        if (logger.isErrorEnabled()) {
            logger.error(buildWarnErrorLog(className, methodName, errorCode, errorMsg, e));
        }
    }

    private static String buildWarnErrorLog(String className, String methodName, String errorCode, String errorMsg,
                                            Exception e) {
        return new StringBuilder().append(className).append("::").append(methodName).append(":").append("[")
                .append(StringUtils.trimToEmpty(errorCode)).append(" ")
                .append((e != null ? e.toString() : StringUtils.trimToEmpty(errorMsg))).toString();
    }

    public static BaseResponseDTO<Void> printAndReturnPopExceptionLog(Logger logger, String className, String methodName, String errorCode,
                                                                   String errorMsg, Exception e, String requestId, String dynamicCode, String dynamicMessage) {
        if (logger.isErrorEnabled()) {
            logger.error(buildWarnErrorLog(className, methodName, errorCode, errorMsg, e));
        }
        final BaseResponseDTO<Void> badResponse = BaseResponseDTO.createFailResult(errorCode, errorMsg);
        badResponse.setRequestId(requestId);
        badResponse.setDynamicCode(dynamicCode);
        badResponse.setDynamicMessage(dynamicMessage);
        return badResponse;
    }

    public static BaseResponseDTO<Void> printAndReturnPopExceptionLog(Logger logger, String className, String methodName, String errorCode,
                                                                   String errorMsg, Exception e, String requestId) {
        if (logger.isErrorEnabled()) {
            logger.error(buildWarnErrorLog(className, methodName, errorCode, errorMsg, e));
        }
        final BaseResponseDTO<Void> badResponse = BaseResponseDTO.createFailResult(errorCode, errorMsg);
        badResponse.setRequestId(requestId);
        return badResponse;
    }

    public static BaseResponseDTO<Void> printAndReturnPopExceptionLog(Logger logger, String className, String methodName, String errorCode,
                                                                   String errorMsg, Exception e, String requestId, Integer httpStatusCode) {
        if (logger.isErrorEnabled()) {
            logger.error(buildWarnErrorLog(className, methodName, errorCode, errorMsg, e));
        }
        final BaseResponseDTO<Void> badResponse = BaseResponseDTO.createFailResult(errorCode, errorMsg);
        badResponse.setRequestId(requestId);
        badResponse.setHttpStatusCode(httpStatusCode);
        return badResponse;
    }
}
