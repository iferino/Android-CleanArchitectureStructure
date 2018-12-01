package com.iferino.country.di;


import com.iferino.country.AndroidApplication;
import com.iferino.data.network.di.NetworkModule;
import com.iferino.data.network.di.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ActivityBuilder.class,
        NetworkModule.class,
        ServiceModule.class
})
public interface ApplicationComponent extends AndroidInjector<AndroidApplication> {
}