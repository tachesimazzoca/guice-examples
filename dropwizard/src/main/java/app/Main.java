package app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import app.conf.AppConfiguration;
import app.controllers.*;

public class Main extends Application<AppConfiguration> {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "guice-dropwizard";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) {
        try {
            Injector injector;
            Class<?> moduleClass = Class.forName("app.conf."
                    + configuration.getModuleName());
            injector = Guice.createInjector((AbstractModule) moduleClass
                    .newInstance());
            environment.jersey().register(
                    injector.getInstance(PagesController.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
