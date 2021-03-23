package com.yd.yx.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

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
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().contentTypeOptions().disable();
        http.headers().frameOptions().sameOrigin();
        http
            .authorizeRequests()
                .antMatchers("/", "/home","/user/login",
                        "/favicon.ico","/templates/**", "/img/**", "/css/**")
                .permitAll()
                .anyRequest().authenticated()
                // 配置登陆页面。
            .and()
                .formLogin()
                .loginPage("/login").permitAll()
                //.loginProcessingUrl("/user/login").permitAll().failureForwardUrl("/login123").permitAll()
            .and()
                //csrf 校验
                .csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                .and()
                .logout().logoutUrl("/logout")
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
         PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
         UserDetails user = User.withUsername("user")
                        .password(encoder.encode("password"))
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}
