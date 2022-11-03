package org.example.auth;

import lombok.extern.slf4j.Slf4j;
import org.example.auth.dto.LoginRequest;
import org.example.auth.dto.LoginResponse;
import org.example.auth.model.UserProfile;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Slf4j
public class AuthServiceImpl implements AuthService {
    @Override
    public Mono<LoginResponse> login(LoginRequest lr) {
        log.info("Handling login request : {}", lr);
        return Mono.just(new LoginResponse("token"));
    }

    @Override
    public Mono<UserProfile> fetchUserProfile(String token) {
        log.info("Fetching user profile");
        return Mono.just(new UserProfile("Kshitij Dhakal", "xyz@example.org", "", Instant.now(), Instant.now()));
    }
}
