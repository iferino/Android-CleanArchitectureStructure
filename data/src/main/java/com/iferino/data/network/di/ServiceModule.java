package com.iferino.data.network.di;


import com.iferino.data.network.ApiClient;
import com.iferino.data.network.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    ApiService provideApiService(ApiClient apiClient) {
        return apiClient.createService(ApiService.class);
    }
}

