package com.yd.yx.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthApplicationController {
    @GetMapping("/health")
    public Object healthCheck(Authentication authentication){
        return authentication;
    }
}
