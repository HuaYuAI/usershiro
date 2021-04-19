package com.yd.yx.userservice.config.login;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSessionExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        HttpServletResponse response = event.getResponse();
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("您的账号已经在别的地方登录，当前登录已失效。如果密码遭到泄露，请立即修改密码！");
    }


//    SessionRegistry包含了一些使用的操作Session的方法，比如：
//
//    踢出用户（让Session失效）：
//
//    String currentSessionId = request.getRequestedSessionId();
//sessionRegistry.getSessionInformation(sessionId).expireNow();
//    获取所有Session信息：
//
//    List<Object> principals = sessionRegistry.getAllPrincipals();

}