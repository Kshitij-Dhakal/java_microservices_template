package org.example.auth;

import lombok.extern.slf4j.Slf4j;
import org.example.auth.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
public class AuthHandler {
    @Autowired
    private AuthService authService;

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(LoginRequest.class)
                .flatMap(lr -> authService.login(lr))
                .flatMap(lr -> ok().bodyValue(lr));
    }
}
