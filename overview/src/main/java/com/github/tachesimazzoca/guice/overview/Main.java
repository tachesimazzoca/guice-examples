package com.github.tachesimazzoca.guice.overview;

import com.google.inject.Guice;
import com.google.inject.Injector;

import com.github.tachesimazzoca.guice.overview.inject.AccountModule;
import com.github.tachesimazzoca.guice.overview.controller.AccountController;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AccountModule());
        AccountController controller = injector.getInstance(AccountController.class);
        controller.print();
    }
}
