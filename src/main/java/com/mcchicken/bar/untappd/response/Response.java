package com.mcchicken.bar.untappd.response;

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