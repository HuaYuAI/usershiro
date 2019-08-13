package com.huayu.shiro.service;

import com.huayu.shiro.api.user.User;
import com.huayu.shiro.api.user.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * Created by huayu on 2019/6/1.
 */
@Service
public class UserServiceProxy /*implements UserService */{

/*    private static final String PROVIDER_SERVER_URL_PREFIX="http://springcloud-erurka-provider/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean save(User user) {
        User returnValue = restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX+"/user/save",user.getUsername(),User.class);
        return returnValue != null;
    }

    @Override
    public Collection<User> findAll() {
        return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX+"/user/list",Collection.class);
    }*/
}
