package com.iferino.presentation.presenter;

import com.iferino.presentation.views.MainActivityView;

import javax.inject.Inject;


public class MainPresenter {

    private MainActivityView view;

    @Inject
    public MainPresenter() {
    }

    public void setView(MainActivityView view) {
        this.view = view;
    }

    public void addValue(int a, int b) {

        view.showText("add result is :" + (a+b));
    }
}
