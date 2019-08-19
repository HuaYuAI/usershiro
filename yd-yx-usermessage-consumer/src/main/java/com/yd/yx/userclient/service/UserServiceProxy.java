package com.yd.yx.userclient.service;

import com.yd.yx.userclientapi.dto.base.BaseResultDTO;
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
    public BaseResultDTO<Boolean> checkUsername(CheckUserMessageRequestDTO checkUserMessageRequestDTO) {
        return null;
    }

    @Override
    public BaseResultDTO registeredUser(RegisteredUserMessageRequestDTO registeredUserMessageRequestDTO) {
        restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX+"user/registered"
                ,registeredUserMessageRequestDTO,BaseResultDTO.class);
        return new BaseResultDTO();
    }

    @Override
    public BaseResultDTO updateUserMessage(UpdateUserMessageRequestDTO updateUserMessageRequestDTO) {
        return null;
    }

    @Override
    public BaseResultDTO userContent(ContentUserMessageRequestDTO contentUserMessageRequestDTO) {
        return null;
    }

    @Override
    public BaseResultDTO userLogIn(LoginUserMessageRequestDTO loginUserMessageRequestDTO) {
        return null;
    }

    @Override
    public BaseResultDTO userLogOut(LogOutUserMessageRequestDTO logOutUserMessageRequestDTO) {
        return null;
    }
}
