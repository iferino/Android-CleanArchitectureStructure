package com.iferino.presentation.presenter;

import android.util.Log;

import com.iferino.domain.entity.Country;
import com.iferino.domain.interactor.BaseInteractor;
import com.iferino.domain.interactor.CountryCase;
import com.iferino.presentation.views.MainActivityView;

import java.util.List;

import javax.inject.Inject;


public class MainPresenter {

    private MainActivityView view;

    private final CountryCase countryCase;

    @Inject
    public MainPresenter(CountryCase countryCase) {
        this.countryCase = countryCase;
    }

    public void setView(MainActivityView view) {
        this.view = view;
    }

    public void addValue(int a, int b) {

        countryCase.getCountryList();
        countryCase.execute(new GetCountrySubscriber());


//        countryRepository.getCountryList().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Country>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.i(" LogApi ", "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(List<Country> list) {
//                        Log.i(" LogApi ", list.get(0).getName());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.i(" LogApi ", e.getMessage());
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.i(" LogApi ", "onComplete");
//
//                    }
//                });

        view.showText("add result is :" + (a+b));
    }

    private class GetCountrySubscriber extends BaseInteractor.Subscriber<List<Country>> {
        @Override
        public void onNext(List<Country> countries) {
            Log.i(" LogApi ", countries.get(0).getName());
        }
    }
}
