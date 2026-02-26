package com.app.user;

import java.util.Optional;

public interface AuthenticationStrategy {
    Optional<User> authenticate(String email, String password);
}