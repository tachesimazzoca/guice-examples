package com.github.tachesimazzoca.guice.web.core;

public final class RoutingException extends Exception {
    public RoutingException() {
    }

    public RoutingException(String message) {
        super(message);
    }

    public RoutingException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoutingException(Throwable cause) {
        super(cause);
    }
}
