package com.yd.yx.userclient.service;

import com.yd.yx.userclientapi.dto.ResultDTO;
import com.yd.yx.userclientapi.dto.UserMessageDTO;
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

    public ResultDTO save(UserMessageDTO user){
        restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX+"user/save"
                ,user,ResultDTO.class);
        return new ResultDTO();
    }
}
