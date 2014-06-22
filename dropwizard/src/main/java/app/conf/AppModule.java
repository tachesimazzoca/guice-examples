package app.conf;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.google.inject.TypeLiteral;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

import app.controllers.*;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PagesController.class);

       TypeLiteral<Map<String, Object>> mapType =
               new TypeLiteral<Map<String, Object>>() {};
           
       Map<String, String> config = ImmutableMap.<String, String>builder()
               .put("title", "Guice on Dropwizard").build();

       bind(mapType)
           .annotatedWith(Names.named("params"))
           .toInstance(ImmutableMap.<String, Object>builder()
           .put("config", config)
           .build());
    }
}
