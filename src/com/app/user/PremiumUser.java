package com.app.user;

public class PremiumUser extends User {
	public PremiumUser(UserBuilder builder) {
		super(builder.getEmail(), builder.getPasswordHash(), builder.getName());
	}
}