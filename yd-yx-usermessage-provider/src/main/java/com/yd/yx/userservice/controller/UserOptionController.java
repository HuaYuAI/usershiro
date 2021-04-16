package com.yd.yx.userservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yd.yx.client.dto.BaseResponseDTO;
import com.yd.yx.common.exception.CommonException;
import com.yd.yx.common.log.controller.ControllerLogs;
import com.yd.yx.userclient.api.dto.user.request.*;
import com.yd.yx.userclient.api.dto.user.response.LoginUserMessageResponseDTO;
import com.yd.yx.userclient.api.dto.user.response.RegisteredUserMessageResponseDTO;
import com.yd.yx.userclient.api.service.UserMessageService;
import com.yd.yx.userservice.service.JwtTokenService;
import com.yd.yx.userservice.service.impl.UserMessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class UserOptionController implements UserMessageService {

    @Autowired
    UserMessageServiceImpl userMessageService;

    @Autowired
    JwtTokenService jwtTokenService;

    @GetMapping("/user/hello")
    public String gethello(){
        return "hello xian";
    }

    @Override
    @GetMapping("/user/check/{username}")
    @HystrixCommand(fallbackMethod = "defaultStores", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
            @HystrixProperty(name = "fallback.enabled", value = "true")
    })
    @ControllerLogs
    public BaseResponseDTO<Boolean> checkUsername(@PathVariable("username") String username) {
        if (StringUtils.isEmpty(username)) {
            throw new CommonException("500", "user.message.checkusername.null");
        }
        BaseResponseDTO baseResponseDTO = userMessageService.checkUsername(username);
        return baseResponseDTO;
    }

    public BaseResponseDTO<Boolean> defaultStores(String message) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode("500");
        baseResponseDTO.setMessage("system.error.select.timeout");
        return baseResponseDTO;
    }

    @Override
    @ControllerLogs
    @PostMapping("/user/register")
    public BaseResponseDTO<RegisteredUserMessageResponseDTO> registeredUser
            (@RequestBody RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO) {
        return userMessageService.registeredUser(registeredUserMessageRequestDTO);
    }

    @Override
    @PutMapping("/user/editor")
    @ControllerLogs
    public BaseResponseDTO updateUserMessage(UpdateUserMessageRequestDTO updateUserMessageRequestDTO) {

        return null;
    }

    @Override
    public BaseResponseDTO userContent(ContentUserMessageRequestDTO contentUserMessageRequestDTO) {
        jwtTokenService.getInfoFromToken(contentUserMessageRequestDTO.getToken());

        return null;
    }

    @Override
    @PostMapping("/user/login")
    @ControllerLogs
    // 或者
    // @Secured("ROLE_admin")
    // 并且
    // @PreAuthorize("hasRole('')")
    // 根据返回值判断
    // @PostAuthorize("returnObject==1")
    public BaseResponseDTO<LoginUserMessageResponseDTO> userLogIn(LoginUserMessageRequestDTO loginUserMessageRequestDTO) {
        // jwtTokenService.generatorToken(new JwtInfo(loginUserMessageRequestDTO.getUsername()));
        // "访问的资源需要身份认证！";
        return null;
    }

    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @GetMapping("/authentication/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")){
                redirectStrategy.sendRedirect(request, response, "/login.html");
                return null;
            }
        }
        return "访问的资源需要身份认证！";
    }

//    @GetMapping("index")
//    public Object index(){
//        return SecurityContextHolder.getContext().getAuthentication();
//    }

    @GetMapping("index")
    public Object index(Authentication authentication) {
        return authentication;
    }

    @Override
    @GetMapping("/user/logout")
    @ControllerLogs
    public BaseResponseDTO userLogOut(LogOutUserMessageRequestDTO logOutUserMessageRequestDTO) {
        return null;
    }

}