package com.app.user;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

    	// ------------------ REGISTER ------------------
    	System.out.print("Enter Name: ");
    	String name = sc.nextLine();

    	System.out.print("Enter Email: ");
    	// During registration
    	String email = sc.nextLine().trim().toLowerCase();

    	System.out.print("Enter Password: ");
    	String password = sc.nextLine();

    	try {
    	    ValidationUtil.validateEmail(email);
    	    ValidationUtil.validatePassword(password);
    	} catch (ValidationException e) {
    	    System.out.println("Registration failed: " + e.getMessage());
    	    sc.close();
    	    return;
    	}

    	String hashedPassword = PasswordUtil.hashPassword(password);
    	User newUser = new User(email, hashedPassword, name);
    	BasicAuth.registerUser(newUser);

    	System.out.println("\nUser Registered Successfully!");
    	System.out.println("Name: " + name);
    	System.out.println("Email: " + email);
    	System.out.println("Hashed Password: " + hashedPassword);

    	// ------------------ LOGIN ------------------
    	System.out.println("\n----- LOGIN -----");
    	System.out.print("Enter Email: ");
    	

    	// During login
    	String loginEmail = sc.nextLine().trim().toLowerCase();

    	System.out.print("Enter Password: ");
    	String loginPassword = sc.nextLine();

    	AuthenticationStrategy strategy = new BasicAuth();
    	Optional<User> loggedInUser = strategy.authenticate(loginEmail, loginPassword);

    	loggedInUser.ifPresentOrElse(
    	    u -> {
    	        SessionManager.getInstance().createSession(u);
    	        System.out.println("Login Successful!");
    	    },
    	    () -> System.out.println("Invalid Credentials")
    	);
    	System.out.println("Registration Hash: " + hashedPassword);
    	System.out.println("Login Hash: " + PasswordUtil.hashPassword(loginPassword));
        sc.close();
    }

}