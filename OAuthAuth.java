package com.app.user;

import java.util.Optional;

public class OAuthAuth implements AuthenticationStrategy {

    @Override
    public Optional<User> authenticate(String email, String password) {

        // Simulated OAuth login
        if (email.endsWith("@google.com")) {
            return Optional.of(new User(email, "", "", ""));
        }

        return Optional.empty();
    }
}