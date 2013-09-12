package com.github.tachesimazzoca.guice.overview.service;

import com.github.tachesimazzoca.guice.overview.dao.AccountDao;

import com.google.inject.Inject;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    @Inject
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String[] getAllAccountNames() {
        return this.accountDao.getAllAccountNames();
    }
}
