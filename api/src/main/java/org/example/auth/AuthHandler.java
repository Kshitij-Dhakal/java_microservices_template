package org.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class AuthHandler {
    @Autowired
    private WebClient.Builder webClient;

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        return webClient
                .build()
                .get()
                .uri("lb://auth-server/v1/auth/login")
                .retrieve()
                .bodyToMono(LoginResponse.class)
                .flatMap(lr -> ServerResponse.ok().body(BodyInserters.fromValue(lr)));
    }
}
