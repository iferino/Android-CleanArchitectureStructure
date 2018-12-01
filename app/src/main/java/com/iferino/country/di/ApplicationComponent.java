package com.iferino.country.di;


import com.iferino.country.AndroidApplication;
import com.iferino.data.di.RepositoryModule;
import com.iferino.data.network.di.NetworkModule;
import com.iferino.data.network.di.ServiceModule;
import com.iferino.domain.di.UseCaseModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidModule.class,
        ActivityBuilder.class,
        UseCaseModule.class,
        RepositoryModule.class,
        NetworkModule.class,
        ServiceModule.class
})
public interface ApplicationComponent extends AndroidInjector<AndroidApplication> {
}