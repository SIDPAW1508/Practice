package com.app.user;

public class FreeUser extends User {
	public FreeUser(UserBuilder builder) {
		super(builder.getEmail(), builder.getPasswordHash(), builder.getName());
	}
}