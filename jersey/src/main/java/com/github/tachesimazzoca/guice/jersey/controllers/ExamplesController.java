package com.github.tachesimazzoca.guice.jersey.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/examples")
public class ExamplesController {
    @GET
    @Path("hello")
    public Response hello() {
        return Response.status(Response.Status.OK)
                .header("Content-Type", MediaType.TEXT_PLAIN).entity("hello")
                .build();
    }

    @GET
    @Path("redirect")
    public Response redirect(@Context UriInfo uinfo) {
        String loc = UriBuilder.fromResource(this.getClass()).path("hello")
                .build().toString();
        return Response.seeOther(uinfo.getBaseUriBuilder().path(loc).build())
                .build();
    }

    @GET
    @Path("headers")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> headers(@Context HttpHeaders headers) {
        Map<String, Object> m = new HashMap<String, Object>();
        for (Map.Entry<String, List<String>> entry : headers
                .getRequestHeaders().entrySet()) {
            List<String> vs = entry.getValue();
            if (vs.size() > 1)
                m.put(entry.getKey(), vs);
            else
                m.put(entry.getKey(), vs.get(0));
        }
        return m;
    }

    @GET
    @Path("parameters")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> parameters(@Context HttpServletRequest req) {
        Map<String, Object> m = new HashMap<String, Object>();
        java.util.Enumeration<?> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String k = (String) names.nextElement();
            String[] vs = req.getParameterValues(k);
            if (vs.length > 1)
                m.put(k, vs);
            else
                m.put(k, vs[0]);
        }
        return m;
    }
}
