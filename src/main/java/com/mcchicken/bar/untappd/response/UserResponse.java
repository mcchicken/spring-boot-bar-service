package com.mcchicken.bar.untappd.response;

import com.mcchicken.bar.untappd.domain.User;

public class UserResponse {
    private final User user;

    public UserResponse() {
        this.user = null;
    }

    public UserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}
