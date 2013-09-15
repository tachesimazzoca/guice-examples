package com.github.tachesimazzoca.guice.web.inject;

import com.google.inject.AbstractModule;

import com.github.tachesimazzoca.guice.web.core.Router;
import com.github.tachesimazzoca.guice.web.router.AppRouter;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Router.class).to(AppRouter.class);
    }
}
