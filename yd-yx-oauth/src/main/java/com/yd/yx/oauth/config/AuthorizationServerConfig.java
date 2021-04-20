package com.yd.yx.oauth.config;

import com.yd.yx.oauth.service.impl.UserMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserMessageServiceImpl userDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenStore jwtTokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenEnhancer tokenEnhancer;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancers = new ArrayList<>();
        enhancers.add(tokenEnhancer);
        enhancers.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(enhancers);

        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailService)
                .tokenStore(jwtTokenStore).accessTokenConverter(jwtAccessTokenConverter).tokenEnhancer(enhancerChain);

    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("isAuthenticated()"); // 获取密钥需要身份认证
    }

    // BaseClientDetails
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                    .withClient("yd-yx-gateway")
                    .secret(passwordEncoder.encode("test1111"))
                    .accessTokenValiditySeconds(3600)
                    .refreshTokenValiditySeconds(864000)
                    .scopes("all", "a", "b", "c")
                    .authorizedGrantTypes("password", "refresh_token","authorization_code")
                    .autoApprove(true)
                    .redirectUris("http://127.0.0.1:9090/gateway/login")
                .and()
                    .withClient("usermessage-consumer")
                    .secret(passwordEncoder.encode("test1111"))
                    .accessTokenValiditySeconds(7200)
                    .scopes("all", "a", "b", "c")
                    .authorizedGrantTypes("password", "refresh_token","authorization_code")
                    .autoApprove(true).redirectUris("http://127.0.0.1:4475/usermessage-consumer/login");
    }

//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("app-a")
//                .secret(passwordEncoder.encode("app-a-1234"))
//                .authorizedGrantTypes("refresh_token","authorization_code")
//                .accessTokenValiditySeconds(3600)
//                .scopes("all")
//                .autoApprove(true)
//                .redirectUris("http://127.0.0.1:9090/app1/login")
//                .and()
//                .withClient("app-b")
//                .secret(passwordEncoder.encode("app-b-1234"))
//                .authorizedGrantTypes("refresh_token","authorization_code")
//                .accessTokenValiditySeconds(7200)
//                .scopes("all")
//                .autoApprove(true)
//                .redirectUris("http://127.0.0.1:9091/app2/login");
//    }

}
