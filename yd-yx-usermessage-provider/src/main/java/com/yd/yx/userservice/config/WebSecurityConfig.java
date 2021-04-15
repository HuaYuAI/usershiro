package com.yd.yx.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author huayu
 * @Date 2020-03-26 17:40
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginAuthenticationSucess loginAuthenticationSucess;

    @Autowired
    LoginAuthenticationFailure loginAuthenticationFailure;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().contentTypeOptions().disable();
        http.headers().frameOptions().sameOrigin();
        http
            .authorizeRequests()// 授权配置
                .antMatchers("/", "/home","/login","/user/register","/error","/authentication/require","/login.html",
                        "/favicon.ico","/templates/**", "/img/**", "/css/**")
                .permitAll()
                .anyRequest()// 所有请求
                .authenticated()// 都需要认证
                // 配置登陆页面。
            .and()
                // .httpBasic() // HTTP Basic方式,浮动窗口
                .formLogin() // 表单方式
                //.loginPage("/login")
                .loginPage("/authentication/require")// 登录跳转 URL
                //.permitAll()
                .loginProcessingUrl("/login")// 处理表单登录 URL
                .successHandler(loginAuthenticationSucess) // 处理登录成功
                .failureHandler(loginAuthenticationFailure) // 处理登录失败
                .permitAll()
                //.loginProcessingUrl("/user/login").permitAll().failureForwardUrl("/login123").permitAll()
            .and()
                //csrf 校验
                .csrf().disable()
                // .csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                //.and()
                .logout().logoutUrl("/logout")
                .permitAll();

//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.formLogin() // 表单登录
//                    // http.httpBasic() // HTTP Basic
//                    .loginPage("/authentication/require") // 登录跳转 URL
//                    .loginProcessingUrl("/login") // 处理表单登录 URL
//                    .successHandler(authenticationSucessHandler) // 处理登录成功
//                    .failureHandler(authenticationFailureHandler) // 处理登录失败
//                    .and()
//                    .authorizeRequests() // 授权配置
//                    .antMatchers("/authentication/require", "/login.html").permitAll() // 登录跳转 URL 无需认证
//                    .anyRequest()  // 所有请求
//                    .authenticated() // 都需要认证
//                    .and().csrf().disable();
//        }

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        UserMessage user = User.withUsername("user")
//                        .password(encoder.encode("password"))
//                        .roles("USER")
//                        .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.jdbcAuthentication().dataSource(dataSource).withUser("dave")
//                .password("secret").roles("USER");
//    }
}
