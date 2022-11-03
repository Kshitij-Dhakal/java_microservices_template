package org.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration(proxyBeanMethods = false)
public class AuthRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(AuthHandler authHandler) {
        return route(POST("v1/auth/login"), authHandler::login)
                .andRoute(GET("/v1/auth/login"), authHandler::fetchUserProfile);
    }

}
