package com.yd.yx.userservice.service;

/**
 * Created by huayu on 2019/8/18.
 */
import com.yd.yx.common.exception.CommonException;
import com.yd.yx.common.dto.BaseResponseDTO;
import com.yd.yx.userclientapi.dto.user.request.*;
import com.yd.yx.userclientapi.dto.user.response.RegisteredUserMessageResponseDTO;
import com.yd.yx.userclientapi.service.UserMessageService;
import com.yd.yx.userservice.dao.user.UserMessageRepository;
import com.yd.yx.userservice.entity.user.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

@Slf4j
@Service
public class UserserviceImpl implements UserMessageService {

    @Autowired
    UserMessageRepository userMessageRepository;

    @Override
    public BaseResponseDTO<Boolean> checkUsername(CheckUserMessageRequestDTO checkUserMessageRequestDTO) {
        if (StringUtils.isEmpty(checkUserMessageRequestDTO.getUsername())){
            throw new CommonException("500","user.message.checkusername.null");
        }
        UserMessage userMessage = userMessageRepository.findByUsername(checkUserMessageRequestDTO.getUsername());
        if (userMessage != null){
            throw new CommonException("500","user.message.checkusername.exit");
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode("200");
        baseResponseDTO.setData(true);
        return baseResponseDTO;
    }

    @Override
    public BaseResponseDTO<RegisteredUserMessageResponseDTO> registeredUser(RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO) {
        // 检测用户名
        checkUsername(new CheckUserMessageRequestDTO(registeredUserMessageRequestDTO.getUsername()));
        // 保存用户
        if (saveUser(registeredUserMessageRequestDTO)==null){
            throw new CommonException("500","user.message.common.error");
        };
        // 生成token
        String token = "";
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode("200");
        baseResponseDTO.setData(new RegisteredUserMessageResponseDTO(token));
        return baseResponseDTO;
    }

    private UserMessage saveUser(RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO){
        Date date = new Date();
        UserMessage userMessage = new UserMessage();
        userMessage.setUsername(registeredUserMessageRequestDTO.getUsername());
        // 生成盐值及密码
        String salt = String.valueOf((Math.random()*9+1)*100000);
        userMessage.setSalt(salt);
        String passwored = DigestUtils.md5DigestAsHex((registeredUserMessageRequestDTO.getPassword()+salt).getBytes());
        userMessage.setPassword(passwored);
        userMessage.setLogintime(date);
        userMessage.setRegistertime(date);
        return userMessageRepository.save(userMessage);
    }

    @Override
    public BaseResponseDTO updateUserMessage(UpdateUserMessageRequestDTO updateUserMessageRequestDTO) {
        return null;
    }

    @Override
    public BaseResponseDTO userContent(ContentUserMessageRequestDTO contentUserMessageRequestDTO) {
        return null;
    }

    @Override
    public BaseResponseDTO userLogIn(LoginUserMessageRequestDTO loginUserMessageRequestDTO) {
        return null;
    }

    @Override
    public BaseResponseDTO userLogOut(LogOutUserMessageRequestDTO logOutUserMessageRequestDTO) {
        return null;
    }
}
