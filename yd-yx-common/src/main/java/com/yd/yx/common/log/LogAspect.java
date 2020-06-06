package com.yd.yx.common.log;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yd.yx.common.log.controller.ControllerLogs;
import com.yd.yx.common.utils.CommonLogUtil;
import com.yd.yx.common.utils.CommonStringUtils;
import com.yd.yx.common.utils.IpUtils;
import com.yd.yx.common.utils.UserAgentUtils;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by huayu on 2019/8/22.
 */
@Aspect
@Configuration
@Slf4j
public class LogAspect {

    private static final Integer MAX_OUTPUT_PARAM_LENGTH = 256;

    // 记录每个方法的耗时
    private static ThreadLocal<Map<String, StopWatch>> timeConsumerMap = new ThreadLocal<>();

    /**
     * Service 层切点
     */
    @Pointcut("@annotation(com.yd.yx.common.log.service.ServiceLogs)")
    public void serviceAspect() {
    }

    /**
     * Controller 层切点
     */
    @Pointcut("@annotation(com.yd.yx.common.log.controller.ControllerLogs)")
    public void controllerAspect() {
    }

    /**
     * 前置通知，用于拦截 Controller 层记录的用户操作
     */
    @Before(("controllerAspect()"))
    public void doControllerBefore(JoinPoint joinPoint) {
        try {
            final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
            // 类名
            final String className = joinPoint.getTarget().getClass().getName();
            // 请求方法
            final String methodName = joinPoint.getSignature().getName() + "()";
            // 方法参数，如果参数太长，只截取前 256 个字符
            final String methodParam = Arrays.deepToString(joinPoint.getArgs());
            final String param = StringUtils.isNotBlank(methodParam) && methodParam.length() > MAX_OUTPUT_PARAM_LENGTH ? StringUtils.substring(methodParam, 0, MAX_OUTPUT_PARAM_LENGTH) : methodParam;
            // 方法描述
            String methodDescription = getControllerMethodDescription(joinPoint);
            UserAgent userAgent = UserAgentUtils.getUserAgent(request);

            StringBuilder sb = new StringBuilder(1000);
            sb.append("\n");
            sb.append("********************************* Request Start ***************************************");
            sb.append("\n");
            sb.append("ClassName     :  ").append(className).append("\n");
            sb.append("RequestMethod :  ").append(methodName).append("\n");
            sb.append("RequestParams :  ").append(param).append("\n");
            sb.append("RequestType   :  ").append(request.getMethod()).append("\n");
            sb.append("Description   :  ").append(methodDescription).append("\n");
            sb.append("serverAddr    :  ").append(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()).append("\n");
            sb.append("RemoteAddr    :  ").append(IpUtils.getRemoteAddr(request)).append("\n");
            sb.append("DeviceName    :  ").append(userAgent.getOperatingSystem().getName()).append("\n");
            sb.append("BrowserName   :  ").append(userAgent.getBrowser().getName()).append("\n");
            sb.append("UserAgent     :  ").append(request.getHeader("User-Agent")).append("\n");
            sb.append("RequestUri    :  ").append(CommonStringUtils.abbr(request.getRequestURI(), 255)).append("\n");
            log.info(sb.toString());

            // 记录时间
            if (timeConsumerMap.get() == null) {
                timeConsumerMap.set(new HashMap<>());
            }
            final StopWatch watch = new StopWatch();
            watch.start();
            timeConsumerMap.get().put(className + methodName, watch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 前置通知，用于拦截 Service 层记录的用户操作
     */
    @Before(("serviceAspect()"))
    public void doServiceBefore(JoinPoint joinPoint) {
        try {
            final String className = joinPoint.getTarget().getClass().getName();
            final String methodName = joinPoint.getSignature().getName() + "()";
            final String methodParam = outputBeautyJson(joinPoint.getArgs());
            CommonLogUtil.printBeginLog(log, className, methodName, methodParam);
            // 记录时间
            if (timeConsumerMap.get() == null) {
                timeConsumerMap.set(new HashMap<>());
            }
            final StopWatch watch = new StopWatch();
            watch.start();
            timeConsumerMap.get().put(className + methodName, watch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 后置通知，用于记录 Service 返回信息
     */
    @AfterReturning(returning = "ret", pointcut = "serviceAspect() || controllerAspect()")
    public void doServiceAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        String classname = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName() + "()";
        final String retJson = outputBeautyJson(ret);
        // 如果 retJson 太长，只打印前 256 个字符
        final String retStr = StringUtils.isNotBlank(retJson) && retJson.length() > MAX_OUTPUT_PARAM_LENGTH ? StringUtils.substring(retJson, 0, MAX_OUTPUT_PARAM_LENGTH) : retJson;

        final StopWatch stopWatch = timeConsumerMap.get().get(classname + method);
        stopWatch.stop();

        CommonLogUtil.printEndLog(log, classname, method, retStr, stopWatch.getTotalTimeMillis());
    }

    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerLogs.class).description();
                    break;
                }
            }
        }
        return description;
    }

    public static String outputBeautyJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String json = JSON.toJSONString(object);
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}

