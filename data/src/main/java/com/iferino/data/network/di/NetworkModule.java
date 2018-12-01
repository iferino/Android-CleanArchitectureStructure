package com.iferino.data.network.di;

import android.content.SharedPreferences;

import com.iferino.data.network.ApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public ApiClient provideApiService() {
        return new ApiClient();
    }
}
