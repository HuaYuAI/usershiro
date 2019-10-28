package com.yd.yx.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by huayu on 2019/8/18.
 */
@RefreshScope  // 试试刷新
@RestController
public class GetPropertiesMessage {

    @Value("${my.name}")
    private String myName;

    private final ContextRefresher contextRefresher;

    private final Environment environment;

    @Autowired
    public GetPropertiesMessage(ContextRefresher contextRefresher,
                       Environment environment){
        this.environment = environment;
        this.contextRefresher=contextRefresher;
    }

    // @Async
    @Scheduled(fixedRate = 5*1000)
    public void autoRefresh(){
        Set<String> updatePropertiesNames = contextRefresher.refresh();
        if (!updatePropertiesNames.isEmpty()){
            updatePropertiesNames.stream().forEach(properties -> {
                System.out.println(Thread.currentThread().getName()+
                        properties+ environment.getProperty(properties));
            });
        }

    }

    @GetMapping("/myname")
    public String getName(){
        return myName;
    }


    @Bean
    public MyHealthIndicator myHealthIndicator(){
        return new MyHealthIndicator();
    }


}
