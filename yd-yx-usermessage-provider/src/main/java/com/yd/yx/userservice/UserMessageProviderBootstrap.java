package com.yd.yx.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by huayu on 2019/8/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserMessageProviderBootstrap {

    public static void main(String[] args) {

        SpringApplication.run(UserMessageProviderBootstrap.class, args);
    }


}
