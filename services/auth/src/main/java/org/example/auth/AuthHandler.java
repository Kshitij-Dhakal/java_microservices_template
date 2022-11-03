package org.example.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthHandler {
    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        log.info("Got login request");
//        serverRequest.bodyToMono(LoginRequest.class)
//                .subscribe(loginRequest -> log.info("Login request : {}", loginRequest));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new LoginResponse("token")));
    }
}
