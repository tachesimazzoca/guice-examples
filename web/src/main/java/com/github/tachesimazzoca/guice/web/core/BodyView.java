package com.github.tachesimazzoca.guice.web.core;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class BodyView implements View {
    private String body;

    private BodyView() {
        this.body = null;
    }

    public BodyView(String body) {
        this.body = body;
    }

    public void dispatch(Context context) {
        if (body == null || body.isEmpty()) {
            return;
        }
        HttpServletResponse response = context.getResponse();
        ServletOutputStream os = null;
        try {
            os = response.getOutputStream();
            os.print(body);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(os);
        }
    }
}
