package com.app.user;

public class SessionManager {

    private static SessionManager instance;

    private User loggedInUser;

    private SessionManager() {}

    public static SessionManager getInstance() {

        if (instance == null) {
            instance = new SessionManager();
        }

        return instance;
    }

    public void createSession(User user) {
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void logout() {
        loggedInUser = null;
    }
}