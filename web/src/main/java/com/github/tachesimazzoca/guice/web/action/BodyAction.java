package com.github.tachesimazzoca.guice.web.action;

import javax.servlet.http.HttpServletRequest;

import com.google.inject.servlet.RequestScoped;

import com.github.tachesimazzoca.guice.web.core.Action;
import com.github.tachesimazzoca.guice.web.core.Context;
import com.github.tachesimazzoca.guice.web.core.View;
import com.github.tachesimazzoca.guice.web.core.Views;

@RequestScoped
public class BodyAction implements Action {
    public View execute(Context context) {
        HttpServletRequest request = context.getRequest();
        StringBuilder sb = new StringBuilder();
        sb.append("## request");
        sb.append("\n");
        sb.append("- ContextPath: " + request.getContextPath());
        sb.append("\n");
        sb.append("- PathInfo: " + request.getPathInfo());
        sb.append("\n");
        sb.append("- PathTranslated: " + request.getPathTranslated());
        sb.append("\n");
        sb.append("- RequestURI: " + request.getRequestURI());
        sb.append("\n");
        sb.append("- RequestURL: " + request.getRequestURL().toString());
        sb.append("\n");
        sb.append("- ServletPath: " + request.getServletPath());
        sb.append("\n");
        return Views.body(sb.toString());
    }
}
