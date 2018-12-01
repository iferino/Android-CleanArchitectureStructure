package com.iferino.country.di;

import com.iferino.domain.executor.ThreadExecutor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    // ThreadExecutor provide
    @Provides
    @Singleton
    @Named("subscriberOn")
    ThreadExecutor provideSubscriberOnThreadExecutor() {
        return new ThreadExecutor(Schedulers.newThread());
    }

    @Provides
    @Singleton
    @Named("observerOn")
    ThreadExecutor provideObserverOnExecutionThread() {
        return new ThreadExecutor(AndroidSchedulers.mainThread());
    }
}
