package com.mcchicken.bar.untappd.service.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.StringJoiner;

@Service
public class UntappdService {
    private final RestTemplate restTemplate;

    @Value("${client_id}")              private String clientId;
    @Value("${client_secret}")          private String clientSecret;
    @Value("${untappd.api.url}")        private String untappdApi;
    @Value("${untappd.api.version}")    private String untappdApiVersion;

    public UntappdService() {
        this.restTemplate = new RestTemplate();
    }

    public String untappdUrl() {
        return new StringJoiner("/").add(untappdApi).add(untappdApiVersion).toString();
    }

    public RestTemplate restTemplate() {
        return restTemplate;
    }

    public String clientId() {
        return clientId;
    }

    public String clientSecret() {
        return clientSecret;
    }
}
