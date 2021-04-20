package com.yd.yx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(101)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthorizationServerConfig extends WebSecurityConfigurerAdapter{
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    @Autowired
//    private GateWayAuthenticationSucessHandler authenticationSucessHandler;
//    @Autowired
//    private GateWayAuthenticationFailureHandler authenticationFailureHandler;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//            .formLogin() // 表单登录
//                .loginProcessingUrl("/login") // 处理表单登录 URL
//                .successHandler(authenticationSucessHandler) // 处理登录成功
//                .failureHandler(authenticationFailureHandler) // 处理登录失败
//            .and()
//                .authorizeRequests() // 授权配置
//                .anyRequest()  // 所有请求
//                .authenticated() // 都需要认证
//            .and()
//                .csrf().disable();
//    }

}
