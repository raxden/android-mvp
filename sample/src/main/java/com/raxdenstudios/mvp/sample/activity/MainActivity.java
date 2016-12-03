package com.raxdenstudios.mvp.sample.activity;

import android.content.Context;

public class MainActivity extends BaseActivity<MainActivityPresenter> {

    @Override
    public MainActivityPresenter initializePresenter(Context context) {
        return new MainActivityPresenter(context);
    }

}
