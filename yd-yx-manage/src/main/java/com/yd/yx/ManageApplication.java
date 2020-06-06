package com.yd.yx;


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

//        SpringApplication springApplication = new SpringApplication(ManageApplication.class);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
//        springApplication.run(args);


//        new SpringApplicationBuilder(ManageApplication.class)
//                // 单元测试，PORT=RANDO
//                .properties("server.port=0")
//                .listeners(event -> {
//                    System.out.println("监听到事件："+event.getSource());
//                })
//                .run(args);

//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
//        annotationConfigApplicationContext.register(ManageApplication.class);
//        annotationConfigApplicationContext.refresh();

    }


}
