package com.yd.yx.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;


/**
 * Created by huayu on 2019/8/13.
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer.class, args);
    }
//  docker buildx build .
//  docker exec -t 8cb8d416ff4f /bin/bash
//  docker run -d -p 8989:8989 --name yd-yx-config yd-yx-config
//  docker container logs -f dc8d6c9f36b4
}
