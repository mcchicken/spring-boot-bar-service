package com.mcchicken.bar.domain;

public class User {
    //TODO: map untappd user fields over
    private final String username;
    private int uniqueCheckins;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getUniqueCheckins() {
        return uniqueCheckins;
    }
}
