package com.huayu.shiro.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UsershiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsershiroApplication.class, args);
	}

}
