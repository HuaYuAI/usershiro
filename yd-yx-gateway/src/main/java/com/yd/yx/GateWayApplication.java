package com.yd.yx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Created by huayu on 2019/8/28.
 */
@SpringBootApplication
@EnableOAuth2Sso
@Slf4j
public class GateWayApplication {

    public static final String HELLO_FROM_FAKE_ACTUATOR_METRICS_GATEWAY_REQUESTS = "hello from fake /actuator/metrics/gateway.requests";

//    @Value("${test.uri:http://httpbin.org:80}")
//    String uri;
//
//    @Bean
//    public TokenFilter tokenFilter(){
//        return new TokenFilter();
//    }


    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        String methodName = "customRouteLocator";
//        //@formatter:off
//        // String uri = "http://httpbin.org:80";
//        // String uri = "http://localhost:9080";
//        log.info("进入方法："+methodName);
//        return builder.routes()
//                .route(r -> r.host("**.abc.org").and().path("/anything/png")
//                        .filters(f ->
//                                f.prefixPath("/httpbin")
//                                        .addResponseHeader("X-TestHeader", "foobar"))
//                        .uri(uri)
//                )
//                .route("read_body_pred", r -> r.host("*.readbody.org")
//                        .and().readBody(String.class,
//                                s -> s.trim().equalsIgnoreCase("hi"))
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "read_body_pred")
//                        ).uri(uri)
//                )
//                .route("rewrite_request_obj", r -> r.host("*.rewriterequestobj.org")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "rewrite_request")
//                                .modifyRequestBody(String.class, Hello.class, MediaType.APPLICATION_JSON_VALUE,
//                                        (exchange, s) -> {
//                                            return Mono.just(new Hello(s.toUpperCase()));
//                                        })
//                        ).uri(uri)
//                )
//                .route("rewrite_request_upper", r -> r.host("*.rewriterequestupper.org")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "rewrite_request_upper")
//                                .modifyRequestBody(String.class, String.class,
//                                        (exchange, s) -> {
//                                            return Mono.just(s.toUpperCase() + s.toUpperCase());
//                                        })
//                        ).uri(uri)
//                )
//                .route("rewrite_response_upper", r -> r.host("*.rewriteresponseupper.org")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "rewrite_response_upper")
//                                .modifyResponseBody(String.class, String.class,
//                                        (exchange, s) -> {
//                                            return Mono.just(s.toUpperCase());
//                                        })
//                        ).uri(uri)
//                )
//                .route("rewrite_response_obj", r -> r.host("*.rewriteresponseobj.org")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "rewrite_response_obj")
//                                .modifyResponseBody(Map.class, String.class, MediaType.TEXT_PLAIN_VALUE,
//                                        (exchange, map) -> {
//                                            Object data = map.get("data");
//                                            return Mono.just(data.toString());
//                                        })
//                                .setResponseHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE)
//                        ).uri(uri)
//                )
//                .route(r -> r.path("/image/webp")
//                        .filters(f ->
//                                f.prefixPath("/httpbin")
//                                        .addResponseHeader("X-AnotherHeader", "baz"))
//                        .uri(uri)
//                )
//                .route(r -> r.order(-1)
//                        .host("**.throttle.org").and().path("/get")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .filter(new ThrottleGatewayFilter()
//                                        .setCapacity(1)
//                                        .setRefillTokens(1)
//                                        .setRefillPeriod(10)
//                                        .setRefillUnit(TimeUnit.SECONDS)))
//                        .uri(uri)
//                )
//                .build();
//        //@formatter:on
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> testFunRouterFunction() {
//        String methodName = "testFunRouterFunction";
//        log.info("进入方法："+methodName);
//        RouterFunction<ServerResponse> route = RouterFunctions.route(
//                RequestPredicates.path("/testfun"),
//                request -> ServerResponse.ok().body(BodyInserters.fromObject("hello")));
//        return route;
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> testWhenMetricPathIsNotMeet() {
//        String methodName = "testWhenMetricPathIsNotMeet";
//        log.info("进入方法："+methodName);
//        RouterFunction<ServerResponse> route = RouterFunctions.route(
//                RequestPredicates.path("/actuator/metrics/gateway.requests"),
//                request -> ServerResponse.ok().body(BodyInserters
//                        .fromObject(HELLO_FROM_FAKE_ACTUATOR_METRICS_GATEWAY_REQUESTS)));
//        return route;
//    }
//
//    static class Hello {
//
//        String message;
//
//        Hello() {
//        }
//
//        Hello(String message) {
//            this.message = message;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//    }

    @GetMapping("user")
    public Principal user(Principal principal) {
        return principal;
    }
    @GetMapping("index")
    public String index() {
        return "index";
    }
    @GetMapping("auth/test1")
    @PreAuthorize("hasAuthority('user:add')")
    public String authTest1(){
        return "您拥有'user:add'权限";
    }

    @GetMapping("auth/test2")
    @PreAuthorize("hasAuthority('user:update')")
    public String authTest2(){
        return "您拥有'user:update'权限";
    }
}
