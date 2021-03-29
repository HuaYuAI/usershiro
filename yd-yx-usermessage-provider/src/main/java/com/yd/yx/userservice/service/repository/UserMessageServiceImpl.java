package com.yd.yx.userservice.service.repository;

import com.yd.yx.client.dto.BaseResponseDTO;
import com.yd.yx.common.exception.CommonException;
import com.yd.yx.userclient.api.dto.user.request.*;
import com.yd.yx.userclient.api.dto.user.response.LoginUserMessageResponseDTO;
import com.yd.yx.userclient.api.dto.user.response.RegisteredUserMessageResponseDTO;
import com.yd.yx.userservice.service.JwtTokenService;
import com.yd.yx.userservice.service.repository.dao.UserMessageRepository;
import com.yd.yx.userservice.service.repository.entity.UserMessage;
import com.yd.yx.userservice.utils.jwt.JwtInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class UserMessageServiceImpl implements UserDetailsService {

    @Autowired
    UserMessageRepository userMessageRepository;

    @Autowired
    JwtTokenService jwtTokenService;

    public BaseResponseDTO<Boolean> checkUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new CommonException("500", "user.message.checkusername.null");
        }
        UserMessage userMessage = userMessageRepository.findByUsername(username);
        if (userMessage != null) {
            throw new CommonException("500", "user.message.checkusername.exit");
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode("200");
        baseResponseDTO.setData(true);
        return baseResponseDTO;
    }

    public BaseResponseDTO<RegisteredUserMessageResponseDTO> registeredUser(RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO) {
        // 检测用户名
        checkUsername(registeredUserMessageRequestDTO.getUserName());
        // 保存用户
        if (saveUser(registeredUserMessageRequestDTO) == null) {
            throw new CommonException("500", "user.message.common.error");
        }
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

    public BaseResponseDTO updateUserMessage(UpdateUserMessageRequestDTO updateUserMessageRequestDTO) {
        return null;
    }

    public BaseResponseDTO userContent(ContentUserMessageRequestDTO contentUserMessageRequestDTO) {
        jwtTokenService.getInfoFromToken(contentUserMessageRequestDTO.getToken());

        return null;
    }

    public BaseResponseDTO<LoginUserMessageResponseDTO> userLogIn(LoginUserMessageRequestDTO loginUserMessageRequestDTO) {
        jwtTokenService.generatorToken(new JwtInfo(loginUserMessageRequestDTO.getUserName()));
        return null;
    }

    public BaseResponseDTO userLogOut(LogOutUserMessageRequestDTO logOutUserMessageRequestDTO) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}