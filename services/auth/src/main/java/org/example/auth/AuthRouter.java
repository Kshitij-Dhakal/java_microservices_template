package org.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AuthRouter {
    @Bean
    public RouterFunction<ServerResponse> routers(AuthHandler authHandler) {
        return route(POST("/v1/auth/login"), authHandler::login);
    }
}
