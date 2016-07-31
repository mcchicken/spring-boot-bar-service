package com.mcchicken.bar.untappd.service;

import com.mcchicken.bar.untappd.service.base.UntappdService;
import com.mcchicken.bar.untappd.domain.User;
import com.mcchicken.bar.untappd.response.Response;
import com.mcchicken.bar.untappd.response.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class CheckinRetrievalService extends UntappdService {
    public CheckinRetrievalService() { }

    public int fetchCheckins(String username) {
        String url = untappdUrl() + "/user/info/{username}?client_id={client_id}&client_secret={client_secret}";
        User user = restTemplate().exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Response<UserResponse>>(){},
                username,
                clientId(),
                clientSecret()).getBody().getResponse().getUser();
        return user.getStats().getTotal_checkins();
    }

    public int fetchUniqueBeers(String username) {
        String url = untappdUrl() + "/user/info/{username}?client_id={client_id}&client_secret={client_secret}";
        User user = restTemplate().exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Response<UserResponse>>(){},
                username,
                clientId(),
                clientSecret()).getBody().getResponse().getUser();
        return user.getStats().getTotal_beers();
    }
}