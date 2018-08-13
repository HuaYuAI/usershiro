package com.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
// 811
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.shiro.mapper")
public class UsershiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsershiroApplication.class, args);
	}
}
