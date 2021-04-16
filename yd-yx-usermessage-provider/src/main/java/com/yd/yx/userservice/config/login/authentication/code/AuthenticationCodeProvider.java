package com.yd.yx.userservice.config.login.authentication.code;

import com.yd.yx.userservice.service.impl.UserMessageServiceImpl;
import com.yd.yx.userservice.utils.email.AuthenticationCodeToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationCodeProvider implements AuthenticationProvider {

        private UserMessageServiceImpl userMessageService;

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            AuthenticationCodeToken authenticationToken = (AuthenticationCodeToken) authentication;
            UserDetails userDetails = userMessageService.loadUserByUsername((String) authenticationToken.getPrincipal());

            if (userDetails == null)
                throw new InternalAuthenticationServiceException("未找到与该手机号对应的用户");

            AuthenticationCodeToken authenticationResult = new AuthenticationCodeToken( userDetails.getAuthorities(),userDetails);

            authenticationResult.setDetails(authenticationToken.getDetails());

            return authenticationResult;
        }

        @Override
        public boolean supports(Class<?> aClass) {
            return AuthenticationCodeToken.class.isAssignableFrom(aClass);
        }

        public UserMessageServiceImpl getUserDetailService() {
            return userMessageService;
        }

        public void setUserDetailService(UserMessageServiceImpl userDetailService) {
            this.userMessageService = userDetailService;
        }
}