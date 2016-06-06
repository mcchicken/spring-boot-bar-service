package com.mcchicken.bar.service;

import com.mcchicken.bar.client.UntappdCheckinRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckinServiceController {
    private final UntappdCheckinRetrievalService client;

    @Autowired
    public CheckinServiceController(UntappdCheckinRetrievalService client) {
        this.client = client;
    }

    @RequestMapping("/")
    public String root() {
        return client.toString();
    }

    @RequestMapping("/checkins/{username}")
    public int checkins(@PathVariable("username") String username) {
        return client.fetchCheckins(username);
    }
}
