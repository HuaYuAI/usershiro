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
import com.yd.yx.userservice.service.repository.UserMessageServiceImpl;
import com.yd.yx.userservice.service.repository.entity.UserMessage;
import com.yd.yx.userservice.utils.jwt.JwtInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
public class UserOptionController implements UserMessageService {

    @Autowired
    UserMessageServiceImpl userMessageService;

    @Autowired
    JwtTokenService jwtTokenService;

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
        log.info("调用超时");
        return null;
    }

    @Override
    @PostMapping("/user")
    @ControllerLogs
    public BaseResponseDTO<RegisteredUserMessageResponseDTO> registeredUser(@RequestBody RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO) {
        // 检测用户名
        checkUsername(registeredUserMessageRequestDTO.getUserName());
        // 保存用户
        if (saveUser(registeredUserMessageRequestDTO) == null) {
            throw new CommonException("500", "user.message.common.error");
        }
        ;
        // 生成token
        String token = "";
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode("200");
        baseResponseDTO.setData(new RegisteredUserMessageResponseDTO(token));
        return baseResponseDTO;
    }

    private UserMessage saveUser(RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO) {
        Date date = new Date();
        UserMessage userMessage = new UserMessage();
        userMessage.setUsername(registeredUserMessageRequestDTO.getUserName());
        // 生成盐值及密码
        String salt = String.valueOf((Math.random() * 9 + 1) * 100000);
        userMessage.setSalt(salt);
        String password = DigestUtils.md5DigestAsHex((registeredUserMessageRequestDTO.getPassword() + salt).getBytes());
        userMessage.setPassword(password);
        userMessage.setLogintime(date);
        userMessage.setRegistertime(date);
        return userMessageRepository.save(userMessage);
    }

    @Override
    @PutMapping("/user")
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
    @Secured("ROLE_admin")
    // 并且
    // @PreAuthorize("hasRole('')")
    // 根据返回值判断
    //@PostAuthorize("returnObject==1")
    public BaseResponseDTO<LoginUserMessageResponseDTO> userLogIn(LoginUserMessageRequestDTO loginUserMessageRequestDTO) {
        jwtTokenService.generatorToken(new JwtInfo(loginUserMessageRequestDTO.getUserName()));
        return null;
    }

    @Override
    @GetMapping("/user/logout")
    @ControllerLogs
    public BaseResponseDTO userLogOut(LogOutUserMessageRequestDTO logOutUserMessageRequestDTO) {
        return null;
    }

}