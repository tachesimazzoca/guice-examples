package com.github.tachesimazzoca.guice.web.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class DispatcherServlet extends HttpServlet {
    private Injector injector;

    @Inject
    public DispatcherServlet(Injector injector) {
        this.injector = injector;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Router router = injector.getInstance(Router.class);
        Class<?> clazz = null;
        try {
            clazz = router.route(request);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        Action action = (Action) injector.getInstance(clazz);
        Context context = new Context(request, response);
        View view = action.execute(context);
        if (!response.isCommitted()) {
            view.dispatch(context);
        }
    }
}
