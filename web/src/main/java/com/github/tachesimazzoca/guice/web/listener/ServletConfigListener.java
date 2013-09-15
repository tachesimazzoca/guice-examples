package com.github.tachesimazzoca.guice.web.listener;

import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.Guice;
import com.google.inject.Injector;

import com.github.tachesimazzoca.guice.web.inject.AppServletModule;
import com.github.tachesimazzoca.guice.web.inject.AppModule;

public class ServletConfigListener extends GuiceServletContextListener {
    @Override protected Injector getInjector() {
        return Guice.createInjector(new AppServletModule(), new AppModule());
    }
}
