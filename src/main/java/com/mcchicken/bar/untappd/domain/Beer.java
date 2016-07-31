package com.mcchicken.bar.untappd.domain;

public class Beer {
    private final int count;

    public Beer() {
        this.count = 0;
    }

    public Beer(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
