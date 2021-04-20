package com.yd.yx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by huayu on 2019/8/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableOAuth2Sso
public class UserMessageCousumer {


    public static void main(String[] args) {

        SpringApplication.run(UserMessageCousumer.class, args);
    }

}
