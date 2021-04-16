package com.yd.yx.userservice.service.impl;

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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class UserMessageServiceImpl implements UserDetailsService {

    @Autowired
    UserMessageRepository userMessageRepository;

    @Autowired
    JwtTokenService jwtTokenService;

    @Autowired
    PasswordEncoder passwordEncoder;

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
        checkUsername(registeredUserMessageRequestDTO.getUsername());
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
        UserMessage userMessage = new UserMessage();
        BeanUtils.copyProperties(registeredUserMessageRequestDTO,userMessage);
        userMessage.setPassword(passwordEncoder.encode(registeredUserMessageRequestDTO.getPassword()));
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
        jwtTokenService.generatorToken(new JwtInfo(loginUserMessageRequestDTO.getUsername()));
        return null;
    }

    public BaseResponseDTO userLogOut(LogOutUserMessageRequestDTO logOutUserMessageRequestDTO) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMessage userMessage = userMessageRepository.findByUsername(username);
        return userMessage;
    }

}