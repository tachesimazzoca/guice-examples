package com.github.tachesimazzoca.guice.overview.dao;

import java.util.Arrays;

public class MockAccountDaoImpl implements AccountDao {
    private String[] names = {};

    public String[] getAllAccountNames() {
        return this.names;
    }

    public void setNames(String[] names) {
        this.names = Arrays.copyOf(names, names.length);
    }
}
