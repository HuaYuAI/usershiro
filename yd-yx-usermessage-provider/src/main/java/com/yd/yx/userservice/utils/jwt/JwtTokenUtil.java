package com.yd.yx.userservice.utils.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * Created by huayu on 2019/9/9.
 */
public class JwtTokenUtil {

    private static Key getKeyInstance(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
        byte [] dc = DatatypeConverter.parseBase64Binary("huayu");
        return new SecretKeySpec(dc,signatureAlgorithm.getJcaName());
    }

    // 生成token
    public static String generatorToken(JwtInfo jwtInfo, int expire){
        return Jwts.builder().claim(JwtConstants.JWT_KEY_ID,jwtInfo.getUid())
        .setExpiration(DateTime.now().plusSeconds(expire).toDate())
        .signWith(SignatureAlgorithm.ES256,getKeyInstance()).compact();
    }

    // 根据token获取token中的信息
    public static JwtInfo getTokenInfo(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return new JwtInfo((claims.get(JwtConstants.JWT_KEY_ID).toString()));
    }

}
