package com.iferino.data.network.di;


import com.iferino.data.network.ApiClient;
import com.iferino.data.network.CountryApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    CountryApiService provideApiService(ApiClient apiClient) {
        return apiClient.createService(CountryApiService.class);
    }
}

