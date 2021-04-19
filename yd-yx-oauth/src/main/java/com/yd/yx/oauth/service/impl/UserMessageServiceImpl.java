package com.yd.yx.oauth.service.impl;

import com.yd.yx.oauth.service.repository.dao.UserMessageRepository;
import com.yd.yx.oauth.service.repository.entity.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserMessageServiceImpl implements UserDetailsService {

    @Autowired
    UserMessageRepository userMessageRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMessage userMessage = userMessageRepository.findByUsername(username);
        return userMessage;
    }

}