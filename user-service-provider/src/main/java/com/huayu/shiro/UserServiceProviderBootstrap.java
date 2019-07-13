package com.huayu.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by huayu on 2019/6/1.
 */
@SpringCloudApplication
@EnableDiscoveryClient
public class UserServiceProviderBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderBootstrap.class,args);
    }
}
