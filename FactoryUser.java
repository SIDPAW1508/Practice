package com.app.user;

public class FactoryUser {
	public static User createUser(String type, UserBuilder builder) {
		if (type.equalsIgnoreCase("FREE")) {
			return new FreeUser(builder);
		}
		if (type.equalsIgnoreCase("PREMIUM")) {
			return new PremiumUser(builder);
		}
		throw new IllegalArgumentException("Invalid User Type");
	}
}