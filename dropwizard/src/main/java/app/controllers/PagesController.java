package app.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import java.util.Map;

import app.views.AppView;

@Singleton
@Path("/pages")
@Produces(MediaType.TEXT_HTML)
public class PagesController {
    @Inject @Named("params")
    private Map<String, Object> params;
    
    @GET
    public AppView index() {
        return page("index");
    }

    @GET
    @Path("{name}")
    public AppView page(@PathParam("name") String name) {
        return new AppView("pages/" + name, params);
    }
}
