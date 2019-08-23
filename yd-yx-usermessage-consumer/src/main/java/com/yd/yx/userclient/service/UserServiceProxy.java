package com.yd.yx.userclient.service;

import com.yd.yx.common.dto.BaseResponseDTO;
import com.yd.yx.userclientapi.dto.user.request.*;
import com.yd.yx.userclientapi.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huayu on 2019/8/18.
 */
@Service
public class UserServiceProxy implements UserMessageService {

    private static final String PROVIDER_SERVER_URL_PREFIX = "http://usermessage-provider/";

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public BaseResponseDTO<Boolean> checkUsername(CheckUserMessageRequestDTO checkUserMessageRequestDTO) {
        return null;
    }

    @Override
    public BaseResponseDTO registeredUser(RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO) {
        restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX+"user/registered"
                ,registeredUserMessageRequestDTO,BaseResponseDTO.class);
        return new BaseResponseDTO();
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
