package com.iferino.domain.interactor;

import com.iferino.domain.executor.ThreadExecutor;
import com.iferino.domain.repositoryContractor.CountryRepositoryContractor;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

public class CountryCase extends BaseInteractor {

    private final CountryRepositoryContractor countryRepositoryContractor;

    @Inject
    public CountryCase(@Named(SUBSCRIBER_ON) ThreadExecutor subscriberOn,
                       @Named(OBSERVER_ON) ThreadExecutor observerOn,
                       CountryRepositoryContractor countryRepositoryContractor) {
        super(subscriberOn, observerOn);
        this.countryRepositoryContractor = countryRepositoryContractor;
    }

    public Observable getCountryList() {
        return withObservable(countryRepositoryContractor.getCountryList());
    }
}


