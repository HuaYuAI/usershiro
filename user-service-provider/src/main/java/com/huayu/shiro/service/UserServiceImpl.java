package com.huayu.shiro.service;

import com.huayu.shiro.api.user.User;
import com.huayu.shiro.api.user.dto.UserLoginRequest;
import com.huayu.shiro.api.user.dto.UserLoginResponse;
import com.huayu.shiro.api.user.server.UserService;
import com.huayu.shiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by huayu on 2019/6/1.
 */
@Service
public class UserServiceImpl implements UserService {
;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        return null;
    }
}
