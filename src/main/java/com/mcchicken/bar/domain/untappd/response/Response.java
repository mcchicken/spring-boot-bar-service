package com.mcchicken.bar.domain.untappd.response;

public class Response<T> {
    private final T response;

    public Response() {
        this.response = null;
    }

    public Response(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }
}