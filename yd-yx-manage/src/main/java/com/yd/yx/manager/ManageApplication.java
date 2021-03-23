package com.yd.yx.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by huayu on 2019/8/15.
 */
@SpringBootApplication
@EnableEurekaServer
public class ManageApplication {

    public static void main(String[] args) {

        SpringApplication.run(ManageApplication.class, args);
//  docker run -d -p 9000:9000 --name yd-yx-manage yd-yx-manage

    }

}
