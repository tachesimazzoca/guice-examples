package com.github.tachesimazzoca.guice.overview.entity;

public class Account {
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name != null) ? name : "";
    }
}
