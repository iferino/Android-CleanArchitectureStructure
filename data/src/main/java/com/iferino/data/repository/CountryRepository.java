package com.iferino.data.repository;


import com.iferino.data.entity.CountryEntity;
import com.iferino.data.network.CountryApiService;
import com.iferino.domain.entity.Country;
import com.iferino.domain.repositoryContractor.CountryRepositoryContractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CountryRepository implements CountryRepositoryContractor {

    private CountryApiService countryApiService;

    @Inject
    public CountryRepository(CountryApiService countryApiService) {
        this.countryApiService = countryApiService;
    }

    public Observable<List<Country>> getCountryList() {
        return countryApiService.getCountryList()
                .flatMapIterable(countryEntities -> countryEntities)
                .map(CountryEntity::toDomain)
                .toList()
                .toObservable();
    }
}

