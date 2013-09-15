package com.github.tachesimazzoca.guice.web.core;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspView implements View {
    private String name;

    private JspView() {
    }

    public JspView(String name) {
        this.name = name;
    }

    public void dispatch(Context context) {
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        RequestDispatcher dispatcher = request.getRequestDispatcher(
            "/WEB-INF/jsp/" + name + ".jsp");
        try {
            dispatcher.include(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
