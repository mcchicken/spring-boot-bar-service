package com.mcchicken.bar.service;

import com.mcchicken.bar.domain.User;
import com.mcchicken.bar.untappd.service.CheckinRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class CheckinServiceController {
    private final Map<String, Integer> users;
    private final CheckinRetrievalService client;

    @Autowired
    public CheckinServiceController(CheckinRetrievalService client) {
        this.client = client;
        this.users = new ConcurrentHashMap<>();
    }

    @RequestMapping("/checkins/{username}")
    public int checkins(@PathVariable("username") String username) {
        return client.fetchCheckins(username);
    }

    @RequestMapping("/beers/{username}")
    public int beers(@PathVariable("username") String username) {
        return client.fetchUniqueBeers(username);
    }

    @RequestMapping("/users")
    public List<String> users() {
        return new ArrayList<>(users.keySet());
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        users.put(user.getUsername(), user.getUniqueCheckins());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeUser(@RequestBody User user) {
        users.remove(user.getUsername());
        return ResponseEntity.noContent().build();
    }
}
