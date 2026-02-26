package com.app.user;

import java.util.Optional;
import java.util.Scanner;

public class AuthenticationApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Login Method:");
        System.out.println("1. Basic Auth");
        System.out.println("2. OAuth");

        int choice = sc.nextInt();
        sc.nextLine();

        AuthenticationStrategy strategy;

        if (choice == 1) {
            strategy = new BasicAuth();
        } else {
            strategy = new OAuth();
        }

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Optional<User> result = strategy.authenticate(email, password);

        result.ifPresentOrElse(
            user -> {
                SessionManager.getInstance().createSession(user);
                System.out.println("Login Successful!");
            },
            () -> System.out.println("Invalid Credentials")
        );

        sc.close();
    }
}