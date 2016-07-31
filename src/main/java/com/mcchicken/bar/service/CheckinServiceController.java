package com.mcchicken.bar.service;

import com.mcchicken.bar.untappd.service.CheckinRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckinServiceController {
    private final CheckinRetrievalService client;

    @Autowired
    public CheckinServiceController(CheckinRetrievalService client) {
        this.client = client;
    }

    @RequestMapping("/checkins/{username}")
    public int checkins(@PathVariable("username") String username) {
        return client.fetchCheckins(username);
    }
}
