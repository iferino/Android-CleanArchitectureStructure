package com.iferino.domain.di;

import com.iferino.domain.executor.ThreadExecutor;
import com.iferino.domain.interactor.CountryCase;
import com.iferino.domain.repositoryContractor.CountryRepositoryContractor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.iferino.domain.interactor.BaseInteractor.OBSERVER_ON;
import static com.iferino.domain.interactor.BaseInteractor.SUBSCRIBER_ON;

@Module
public class UseCaseModule {

    @Provides
    @Singleton
    CountryCase provideCountryCase(@Named(SUBSCRIBER_ON) ThreadExecutor subscriberOn,
                                   @Named(OBSERVER_ON) ThreadExecutor observerOn,
                                   CountryRepositoryContractor countryRepositoryContractor) {
        return new CountryCase(subscriberOn, observerOn, countryRepositoryContractor);
    }
}
