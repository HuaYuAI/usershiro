package com.yd.yx.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;

/**
 * Created by huayu on 2019/8/22.
 */
@Component
public class ErrorMsgUtils {

    @Autowired
    private Environment environment;

    public static final String LOCALE_ZH_CN = "zh-CN";
    private static ErrorMsgUtils errorMsgUtils;

    @PostConstruct
    public void init(){
        errorMsgUtils = this;
        errorMsgUtils.environment = this.environment;
    }

    public static String getErrorMsg(String errorCode) {

        return getErrorMsg(errorCode, LOCALE_ZH_CN);
    }

    public static String getErrorMsg(String errorCode, String locale) {
        String tmpMsg = errorMsgUtils.environment.getProperty(errorCode);
        return tmpMsg;
    }

    public static String getErrorMsg(String errorCode, Object[] values) {
        String msg = getErrorMsg(errorCode);
        if (msg != null) {
            return MessageFormat.format(msg, values);
        }
        return null;
    }




}
