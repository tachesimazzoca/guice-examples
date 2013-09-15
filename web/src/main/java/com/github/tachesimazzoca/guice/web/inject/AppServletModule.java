package com.github.tachesimazzoca.guice.web.inject;

import com.google.inject.servlet.ServletModule;

import com.github.tachesimazzoca.guice.web.core.DispatcherServlet;

public class AppServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        serveRegex("^/$", "^(/[-_0-9a-z]+)+(\\.html)?$").with(DispatcherServlet.class);
    }
}
