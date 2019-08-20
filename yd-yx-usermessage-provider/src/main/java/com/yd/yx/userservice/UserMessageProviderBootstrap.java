package com.yd.yx.userservice;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by huayu on 2019/8/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserMessageProviderBootstrap {

    public static void main(String[] args) {
        // @Http.Header
        SpringApplication.run(UserMessageProviderBootstrap.class, args);
    }

}
