package com.yd.yx.userservice.config.login.authentication.code;

import com.yd.yx.userservice.utils.email.AuthenticationCodeToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationCodeFilter extends AbstractAuthenticationProcessingFilter {

    public static final String EMAIL_KEY = "email";

    private String emailParameter = EMAIL_KEY;
    private boolean postOnly = true;


    public AuthenticationCodeFilter() {
        super(new AntPathRequestMatcher("/user/login", "POST"));
    }


    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        String email = obtainEmail(request);

        if (email == null) {
            email = "";
        }

        email = email.trim();

        AuthenticationCodeToken authRequest = new AuthenticationCodeToken(email);

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    protected String obtainEmail(HttpServletRequest request) {
        return request.getParameter(emailParameter);
    }

    protected void setDetails(HttpServletRequest request,
                              AuthenticationCodeToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    public void setEmailParameter(String emailParameter) {
        Assert.hasText(emailParameter, "email parameter must not be empty or null");
        this.emailParameter = emailParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getEmailParameter() {
        return emailParameter;
    }
}
