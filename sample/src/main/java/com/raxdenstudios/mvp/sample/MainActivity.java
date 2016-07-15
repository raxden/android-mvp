package com.raxdenstudios.mvp.sample;

import android.content.Context;
import android.os.Bundle;

public class MainActivity extends BaseActivity<MainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public MainPresenter initializePresenter(Context context) {
        return null;
    }
}
