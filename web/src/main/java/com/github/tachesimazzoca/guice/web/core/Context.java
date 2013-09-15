package com.github.tachesimazzoca.guice.web.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context {
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public Context(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public HttpServletRequest getRequest() {
        return this.request;
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }
}
