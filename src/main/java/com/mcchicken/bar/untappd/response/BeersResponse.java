package com.mcchicken.bar.untappd.response;

import com.mcchicken.bar.untappd.domain.Beer;

import java.util.List;

public class BeersResponse {
    private final List<Beer> beers;

    public BeersResponse() {
        this.beers = null;
    }

    public BeersResponse(List<Beer> beers) {
        this.beers = beers;
    }

    public List<Beer> getBeers() {
        return beers;
    }
}
