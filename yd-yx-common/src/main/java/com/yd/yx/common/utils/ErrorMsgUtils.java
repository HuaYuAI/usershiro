package com.yd.yx.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by huayu on 2019/8/22.
 */
@Component
public class ErrorMsgUtils {

    @Autowired
    private Environment environment;
    @Autowired
    private McmsRealTimeQueryService mcmsRealTimeQueryService;

    public static final String MCMS_APP_NAME = "g11n-tools-error";
    public static final String LOCALE_ZH_CN = "zh-CN";
    private static ErrorMsgUtils errorMsgUtils;

    @PostConstruct
    public void init(){
        errorMsgUtils = this;
        errorMsgUtils.environment = this.environment;
        errorMsgUtils.mcmsRealTimeQueryService = this.mcmsRealTimeQueryService;
    }

    public static String getErrorMsg(String errorCode) {

        return getErrorMsg(errorCode, LOCALE_ZH_CN);
    }

    public static String getErrorMsg(String errorCode, String locale) {
        String tmpMsg = getMsgFromMcms(errorCode, locale);
        if (StringUtils.isBlank(tmpMsg)) {
            tmpMsg = errorMsgUtils.environment.getProperty(errorCode);
        }
        return tmpMsg;
    }

    public static String getErrorMsg(String errorCode, Object[] values) {
        String msg = getErrorMsg(errorCode);
        if (msg != null) {
            return MessageFormat.format(msg, values);
        }
        return null;
    }


    private static String getMsgFromMcms(String key, String locale){
        if (StringUtils.isBlank(key)) {
            return null;
        }

        McmsQueryDTO mcmsQueryDTO = new McmsQueryDTO();
        mcmsQueryDTO.setAppName(MCMS_APP_NAME);
        mcmsQueryDTO.setPageSize(200);
        mcmsQueryDTO.setPageIndex(1);
        mcmsQueryDTO.setResourceKeys(Arrays.asList(key));
        mcmsQueryDTO.setLocale(locale);
        McmsResult<String> result = errorMsgUtils.mcmsRealTimeQueryService
                .queryWithoutPermision(mcmsQueryDTO);
        List<CommonMcmsDTO> mcmsDTOS = null;
        if (result.isSuccess()) {
            JSONObject tagerObject = JSONObject.parseObject(result.getTarget());
            if (tagerObject.getInteger("total") > 0) {
                mcmsDTOS = tagerObject.getJSONArray("list").toJavaList(CommonMcmsDTO.class);
            }
        }

        if (CollectionUtils.isNotEmpty(mcmsDTOS)
                && CollectionUtils.isNotEmpty(mcmsDTOS.get(0).getI18n())) {
            return mcmsDTOS.get(0).getI18n().get(0).getContent();
        }
        return null;
    }

}
