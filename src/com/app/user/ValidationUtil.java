package com.app.user;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com$";

    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$";
    // At least 1 lowercase, 1 uppercase, 1 digit, min 6 chars

    public static void validateEmail(String email) throws ValidationException {

        if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new ValidationException("Invalid Email Format");
        }
    }

    public static void validatePassword(String password) throws ValidationException {

        if (password == null || !Pattern.matches(PASSWORD_REGEX, password)) {
            throw new ValidationException(
                    "Password must contain uppercase, lowercase, digit and be 6+ characters");
        }
    }
}