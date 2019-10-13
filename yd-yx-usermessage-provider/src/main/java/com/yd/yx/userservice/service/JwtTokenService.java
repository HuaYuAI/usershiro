package com.yd.yx.userservice.service;

import com.yd.yx.userservice.utils.JwtInfo;
import com.yd.yx.userservice.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by huayu on 2019/9/9.
 */
@Component
public class JwtTokenService {

    @Value("${jwt.expire}")
    private int expire;

    public String generatorToken(JwtInfo jwtInfo){
        return JwtTokenUtil.generatorToken(jwtInfo,expire);
    }

    public JwtInfo getInfoFromToken(String token){
        return JwtTokenUtil.getTokenInfo(token);
    }

}
