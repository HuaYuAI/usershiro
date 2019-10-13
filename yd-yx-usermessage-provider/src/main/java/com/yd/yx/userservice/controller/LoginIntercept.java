package com.yd.yx.userservice.controller;
import com.yd.yx.common.log.Anoymous;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by huayu on 2019/9/9.
 */
public class LoginIntercept extends HandlerInterceptorAdapter {

    private final String ACCESS_TOKEN = "access_token";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object object){
        HandlerMethod handlerMethod = (HandlerMethod)object;
        if (isAnonymnous(handlerMethod)){
            return true;
        }
        // String accessToken =  CookieUtil.getCookieValue(request,ACCESS_TOKEN);
        return false;
    }

    private boolean isAnonymnous(HandlerMethod handlerMethod){
        Object action = handlerMethod.getBean();
        Class<?> aClass = action.getClass();
        if (aClass.getAnnotation(Anoymous.class)!=null){
            return true;
        }
        Method method = handlerMethod.getMethod();
        return method.getAnnotation(Anoymous.class)!=null;
    }
}
