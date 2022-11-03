package org.example.auth;

import org.example.auth.dto.LoginRequest;
import org.example.auth.dto.LoginResponse;
import org.example.auth.model.UserProfile;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<LoginResponse> login(LoginRequest lr);

    Mono<UserProfile> fetchUserProfile(String token);
}
