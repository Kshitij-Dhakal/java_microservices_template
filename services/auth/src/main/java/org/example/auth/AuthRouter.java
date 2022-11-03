package org.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class AuthRouter {

    @Bean
    public RouterFunction<ServerResponse> route(AuthHandler authHandler) {
        return RouterFunctions
                .route(GET("v1/auth/login")
                        .and(accept(MediaType.APPLICATION_JSON)), authHandler::login);
    }

}
