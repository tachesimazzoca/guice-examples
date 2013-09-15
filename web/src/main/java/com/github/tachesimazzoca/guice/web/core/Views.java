package com.github.tachesimazzoca.guice.web.core;

public final class Views {
    private static final View EMPTY = new BodyView("");

    private Views() {
    }

    public static View empty() {
        return EMPTY;
    }

    public static View body(String body) {
        return new BodyView(body);
    }

    public static View jsp(String name) {
        return new JspView(name);
    }
}
