package com.yd.yx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;

/**
 * Created by huayu on 2019/8/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@Controller
public class UserMessageProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(UserMessageProviderBootstrap.class, args);
    }
//  docker run -p 3306:3306 --name mysql5.7.33 -v /home/shixiaohua/docker/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7.33
//  docker exec -it mysql /bin/bash
//  mysql -u root -p
//  show databases;
//  create DATABASE  IF NOT EXISTS usershiro;
}
