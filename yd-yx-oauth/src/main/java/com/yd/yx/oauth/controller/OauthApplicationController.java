package com.yd.yx.oauth.controller;

import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
public class OauthApplicationController {
    @GetMapping("/health")
    public Object healthCheck(@AuthenticationPrincipal Authentication authentication, HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header, "bearer ");
        return Jwts.parser().setSigningKey("test_key".getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
    }
}
