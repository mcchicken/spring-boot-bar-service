package com.mcchicken.bar.scheduler;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BeerCheckinScheduledTask {
    @Scheduled(fixedDelay = 5000)
    public void displayCheckins() {
        List<String> users = restTemplate().exchange("http://localhost:8080/users",
                                                    HttpMethod.GET,
                                                    null,
                                                    new ParameterizedTypeReference<List<String>>(){})
                                           .getBody();
        users.stream()
                .map(this::getUniqueBeersFor)
                .forEach(System.out::println);
    }

    private int getUniqueBeersFor(String username) {
        return restTemplate().exchange("http://localhost:8080/beers/{username}",
                                        HttpMethod.GET,
                                        null,
                                        new ParameterizedTypeReference<Integer>(){},
                                        username)
                             .getBody();
    }

    private RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
