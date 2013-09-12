package com.github.tachesimazzoca.guice.overview.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import com.github.tachesimazzoca.guice.overview.service.AccountService;

public class AccountController {
    @Inject
    private AccountService accountService;

    @Inject @Named("basedir")
    private String basedir = "";

    public AccountController() {
    }

    public void print() {
        System.out.println(this.accountService);
        System.out.println(this.basedir);
        System.out.println(Arrays.asList(this.accountService.getAllAccountNames()));
    }
}
