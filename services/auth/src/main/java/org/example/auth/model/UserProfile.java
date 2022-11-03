package org.example.auth.model;

import java.time.Instant;

public record UserProfile(String fullName, String email, String profilePic, Instant created, Instant updated) {
}
