package com.iferino.presentation.presenter;

import android.util.Log;

import com.iferino.data.entity.CountryEntity;
import com.iferino.data.repository.CountryRepository;
import com.iferino.presentation.views.MainActivityView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter {

    private MainActivityView view;

    @Inject
    CountryRepository countryRepository;


    @Inject
    public MainPresenter() {
    }

    public void setView(MainActivityView view) {
        this.view = view;
    }

    public void addValue(int a, int b) {

        countryRepository.getCountryList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CountryEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(" LogApi ", "onSubscribe");
                    }

                    @Override
                    public void onNext(List<CountryEntity> list) {
                        Log.i(" LogApi ", list.get(0).getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(" LogApi ", e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.i(" LogApi ", "onComplete");

                    }
                });

        view.showText("add result is :" + (a+b));
    }
}
