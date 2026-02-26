package com.app.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BasicAuth implements AuthenticationStrategy {

    private static Map<String, User> userDB = new HashMap<>();

    public static void registerUser(User user) {
        String originalEmail = user.getEmail();
        String normalizedEmail = originalEmail.trim().toLowerCase();
        
        System.out.println("Original email: " + originalEmail);
        System.out.println("Normalized email: " + normalizedEmail);
        System.out.println("Password hash: " + user.getPasswordHash());
        
        userDB.put(normalizedEmail, user);
        System.out.println("User stored with key: " + normalizedEmail);
    }

    @Override
    public Optional<User> authenticate(String email, String password) {
        String normalizedEmail = email.trim().toLowerCase();
        System.out.println("Authenticating user with email: " + normalizedEmail);
        User user = userDB.get(normalizedEmail);
        if (user == null) {
            System.out.println("User not found!");
            return Optional.empty();
        }
        String hashedInput = PasswordUtil.hashPassword(password);
        System.out.println("Stored hash: " + user.getPasswordHash());
        System.out.println("Input hash: " + hashedInput);
        if (user.getPasswordHash().equals(hashedInput)) {
            System.out.println("Authentication success!");
            return Optional.of(user);
        }
        System.out.println("Password hash mismatch!");
        return Optional.empty();
    }
}