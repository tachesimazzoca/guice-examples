package com.github.tachesimazzoca.guice.web.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.servlet.RequestScoped;

import com.github.tachesimazzoca.guice.web.core.Action;
import com.github.tachesimazzoca.guice.web.core.Context;
import com.github.tachesimazzoca.guice.web.core.View;
import com.github.tachesimazzoca.guice.web.core.Views;

@RequestScoped
public class PagesIndexAction implements Action {
    public View execute(Context context) {
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        String path = request.getServletPath();
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.isEmpty()) {
            path += "index";
        } else {
            path += pathInfo;
        }
        Pattern ptn = Pattern.compile("/pages((?:/[a-z][-_0-9a-z]*)+)(?:\\.html)?");
        Matcher matcher = ptn.matcher(path);
        if (matcher.matches()) {
            return Views.jsp("pages" + matcher.group(1));
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return Views.empty();
        }
    }
}
