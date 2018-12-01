package com.iferino.data.di;

import com.iferino.data.network.CountryApiService;
import com.iferino.data.repository.CountryRepository;
import com.iferino.domain.repositoryContractor.CountryRepositoryContractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    CountryRepositoryContractor provideContryRepository(final CountryApiService countryCountryApiService) {
        return new CountryRepository(countryCountryApiService);
    }
}
