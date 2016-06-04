package com.mcchicken.bar.client;

import com.mcchicken.bar.domain.untappd.User;
import com.mcchicken.bar.domain.untappd.response.Response;
import com.mcchicken.bar.domain.untappd.response.UserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.StringJoiner;

@Component
public class UntappdSpringClient {
    @Value("${client_id}") private String clientId;
    @Value("${client_secret}") private String clientSecret;
    @Value("${untappd.api.url}") private String untappdApi;
    @Value("${untappd.api.version}") private String untappdApiVersion;

    private final RestTemplate restTemplate;

    public UntappdSpringClient() {
        this.restTemplate = new RestTemplate();
    }

    public int fetchCheckins(String username) {
        String url = untappdUrl() + "/user/info/{username}?client_id={client_id}&client_secret={client_secret}";
        User user = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Response<UserResponse>>(){},
                username,
                clientId,
                clientSecret).getBody().getResponse().getUser();
        return user.getStats().getTotal_beers();
    }

    private String untappdUrl() {
        return new StringJoiner("/").add(untappdApi).add(untappdApiVersion).toString();
    }
}