package com.yd.yx.userservice.controller;

import com.yd.yx.userservice.utils.email.AuthenticationCode;
import com.yd.yx.userservice.utils.image.CreateImageCode;
import com.yd.yx.userservice.utils.image.ImageCode;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ValidateController {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    public final static String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";

    public final static String SESSION_KEY_EMAIL_CODE = "SESSION_KEY_EMAIL_CODE";

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = CreateImageCode.createImageCode();
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_IMAGE_CODE, imageCode);
        ImageIO.write(imageCode.getImage(), "jpeg", response.getOutputStream());
    }

    @GetMapping("/code/email/{email}")
    public void createEmailCode(HttpServletRequest request, HttpServletResponse response, @PathVariable("email") String email) throws IOException {
        AuthenticationCode smsCode = createSMSCode();
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_EMAIL_CODE + email, smsCode);
        // 输出验证码到控制台代替短信发送服务
        System.out.println("您的登录验证码为：" + smsCode.getCode() + "，有效时间为60秒");
    }

    private AuthenticationCode createSMSCode() {
        String code = RandomStringUtils.randomNumeric(6);
        return new AuthenticationCode(code, 600);
    }

}
