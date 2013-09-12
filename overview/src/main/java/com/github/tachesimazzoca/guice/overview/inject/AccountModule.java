package com.github.tachesimazzoca.guice.overview.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import com.github.tachesimazzoca.guice.overview.dao.AccountDao;
import com.github.tachesimazzoca.guice.overview.dao.MockAccountDaoImpl;
import com.github.tachesimazzoca.guice.overview.service.AccountService;
import com.github.tachesimazzoca.guice.overview.service.AccountServiceImpl;

public class AccountModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AccountDao.class).to(MockAccountDaoImpl.class);
        bind(AccountService.class).to(AccountServiceImpl.class);
        bind(String.class).annotatedWith(Names.named("basedir"))
            .toInstance("/guice-examples/overview");
    }

    @Provides
    public MockAccountDaoImpl provideMockAccountDaoImpl() {
        MockAccountDaoImpl dao = new MockAccountDaoImpl();
        String[] names = {"foo", "bar"};
        dao.setNames(names);
        return dao;
    }
}
