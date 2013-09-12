package com.github.tachesimazzoca.guice.overview.service;

import com.github.tachesimazzoca.guice.overview.dao.AccountDao;

public interface AccountService {
    void setAccountDao(AccountDao accountDao);

    String[] getAllAccountNames();
}
