package com.yd.yx.userservice.config;

import com.yd.yx.userservice.config.login.AuthenticationSessionExpiredStrategy;
import com.yd.yx.userservice.config.login.authentication.code.AuthenticationAccessDeniedHandler;
import com.yd.yx.userservice.config.login.authentication.code.AuthenticationCodeConfig;
import com.yd.yx.userservice.config.login.authentication.code.AuthenticationCodeLogOutSuccessHandler;
import com.yd.yx.userservice.config.login.authentication.code.AuthenticationCodeOneFilter;
import com.yd.yx.userservice.config.login.filter.LoginAuthenticationFailure;
import com.yd.yx.userservice.config.login.filter.LoginAuthenticationSucess;
import com.yd.yx.userservice.service.impl.UserMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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

    @Autowired
    UserMessageServiceImpl userMessageServiceImpl;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    AuthenticationCodeOneFilter authenticationCodeOneFilter;

    @Autowired
    AuthenticationCodeConfig authenticationCodeConfig;

    @Autowired
    AuthenticationSessionExpiredStrategy authenticationSessionExpiredStrategy;

    @Autowired
    AuthenticationCodeLogOutSuccessHandler logOutSuccessHandler;

    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().contentTypeOptions().disable();
        http.headers().frameOptions().sameOrigin();
        http.exceptionHandling()
                .accessDeniedHandler(authenticationAccessDeniedHandler)
            .and().addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
                .addFilterBefore(authenticationCodeOneFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()// 授权配置
                .antMatchers("/", "/home","/login","/logout",
                        "/user/register","/oauth/token",
                        "/error","/authentication/require",
                        "/login.html","/register.html","/loginemail.html",
                        "/favicon.ico","/templates/**",
                        "/img/**", "/css/**","/js/**","/code/**")
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
                //.permitAll()
                //.loginProcessingUrl("/user/login").permitAll().failureForwardUrl("/login123").permitAll()
            .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository()) // 配置 token 持久化仓库
                .tokenValiditySeconds(60*60*24*7) // remember 过期时间，单为秒
                .userDetailsService(userMessageServiceImpl) // 处理自动登录逻辑
            .and()
                //csrf 校验
                .csrf().disable()
                .apply(authenticationCodeConfig)
                // .csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository())
            .and()
                .logout().logoutUrl("/logout")
                // .logoutSuccessUrl("/signout/success")
                .logoutSuccessHandler(logOutSuccessHandler)
                .deleteCookies("JSESSIONID")
            .and()
                .sessionManagement() // 添加 Session管理器
                .invalidSessionUrl("/session/invalid") // Session失效后跳转到这个链接
                .maximumSessions(2)
                .maxSessionsPreventsLogin(true)
                .expiredSessionStrategy(authenticationSessionExpiredStrategy);


//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//
//            http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加验证码校验过滤器
//                    .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class) // 添加短信验证码校验过滤器
//                    .formLogin() // 表单登录
//                    // http.httpBasic() // HTTP Basic
//                    .loginPage("/authentication/require") // 登录跳转 URL
//                    .loginProcessingUrl("/login") // 处理表单登录 URL
//                    .successHandler(authenticationSucessHandler) // 处理登录成功
//                    .failureHandler(authenticationFailureHandler) // 处理登录失败
//                    .and()
//                    .authorizeRequests() // 授权配置
//                    .antMatchers("/authentication/require",
//                            "/login.html",
//                            "/code/image","/code/sms").permitAll() // 无需认证的请求路径
//                    .anyRequest()  // 所有请求
//                    .authenticated() // 都需要认证
//                    .and()
//                    .csrf().disable()
//                    .apply(smsAuthenticationConfig); // 将短信验证码认证配置加到 Spring Security 中
//        }

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        jdbcTokenRepository.setCreateTableOnStartup(false);
//        CREATE TABLE persistent_logins (
//                username VARCHAR (64) NOT NULL,
//                series VARCHAR (64) PRIMARY KEY,
//                token VARCHAR (64) NOT NULL,
//                last_used TIMESTAMP NOT NULL
//        )
        return jdbcTokenRepository;
    }

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
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
