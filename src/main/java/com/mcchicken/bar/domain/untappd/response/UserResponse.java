package com.mcchicken.bar.domain.untappd.response;

import com.mcchicken.bar.domain.untappd.User;

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
