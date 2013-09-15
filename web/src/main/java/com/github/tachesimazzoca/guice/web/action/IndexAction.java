package com.github.tachesimazzoca.guice.web.action;

import com.google.inject.servlet.RequestScoped;

import com.github.tachesimazzoca.guice.web.core.Action;
import com.github.tachesimazzoca.guice.web.core.Context;
import com.github.tachesimazzoca.guice.web.core.View;
import com.github.tachesimazzoca.guice.web.core.Views;

@RequestScoped
public class IndexAction implements Action {
    public View execute(Context context) {
        return Views.jsp("index");
    }
}
