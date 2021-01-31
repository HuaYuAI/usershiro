package com.yd.yx.userservice.controller;

import com.yd.yx.common.log.Anoymous;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by huayu on 2019/9/9.
 */
@Controller
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

    @GetMapping("/static/img/{img}")
    public ModelAndView img(@PathVariable("static/img") String img) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/static/img/" +img);
        modelAndView.addObject("Content-Type","image/x-png");
//        View view = new View() {
//            @Override
//            public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//                httpServletResponse.setHeader("Content-Type","image/x-png");
//            }
//        };
//        modelAndView.setView(view);
        return modelAndView;
    }
    @GetMapping("/static/css/{css}")
    public ModelAndView css(@PathVariable("static/css") String css) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/static/css/" +css);
        return modelAndView;
    }
}
