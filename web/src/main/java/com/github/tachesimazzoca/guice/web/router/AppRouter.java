package com.github.tachesimazzoca.guice.web.router;

import java.util.Map;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Singleton;

import com.github.tachesimazzoca.guice.web.action.IndexAction;
import com.github.tachesimazzoca.guice.web.action.BodyAction;
import com.github.tachesimazzoca.guice.web.action.PagesIndexAction;

import com.github.tachesimazzoca.guice.web.core.Router;
import com.github.tachesimazzoca.guice.web.core.RoutingException;

@Singleton
public class AppRouter implements Router {
    private static final Map<String, Class<?>> MAPPINGS =
        new LinkedHashMap<String, Class<?>>() {
            {
                put("^/(?:index(?:\\..*)?)?$", IndexAction.class);
                put("^/body(?:\\..*)?$", BodyAction.class);
                put("^/pages/(?:.+)?$", PagesIndexAction.class);
            }
        };

    public Class<?> route(HttpServletRequest request) throws RoutingException {
        String path = request.getServletPath();
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && !pathInfo.isEmpty()) {
            path += pathInfo;
        }
        for (Map.Entry<String, Class<?>> mapping : MAPPINGS.entrySet()) {
            if (path.matches(mapping.getKey())) {
                return mapping.getValue();
            }
        }
        throw new RoutingException();
    }
}
