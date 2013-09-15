package com.github.tachesimazzoca.guice.web.core;

import javax.servlet.http.HttpServletRequest;

public interface Router {
    Class<?> route(HttpServletRequest request) throws RoutingException;
}
