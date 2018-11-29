package com.iferino.country.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.iferino.country.R;
import com.iferino.presentation.presenter.MainPresenter;
import com.iferino.presentation.views.MainActivityView;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.textView)
    TextView textView;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter.setView(this);
        presenter.addValue(5, 10);
    }

    @Override
    public void showText(@NotNull String text) {
        textView.setText(text);
    }
}
