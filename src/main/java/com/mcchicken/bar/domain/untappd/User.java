package com.mcchicken.bar.domain.untappd;

public class User {
    private final Stats stats;

    public User() {
        this.stats = null;
    }

    public User(Stats stats) {
        this.stats = stats;
    }

    public Stats getStats() {
        return stats;
    }
}
