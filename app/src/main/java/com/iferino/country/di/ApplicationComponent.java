package com.iferino.country.di;


import com.iferino.country.AndroidApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = { AndroidInjectionModule.class, ActivityBuilder.class})
public interface ApplicationComponent extends AndroidInjector<AndroidApplication> {
}