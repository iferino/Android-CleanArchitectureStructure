package com.iferino.presentation.presenter

import com.iferino.presentation.views.MainActivityView
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(val view: MainActivityView) {

    fun add(a: Int, b: Int) {
        view.showText("Result is ${a+b}")
    }

}
