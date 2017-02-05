package com.raxdenstudios.mvp.sample.activity;

import android.content.Context;

import com.raxdenstudios.mvp.MVPActivity;

public class MainActivity extends MVPActivity<MainActivityPresenter> implements MainActivityView {

    @Override
    public MainActivityPresenter initializePresenter(Context context) {
        return new MainActivityPresenter(context);
    }

    /**
     * Sample method that simulate login click
     */
    public void onLoginClick() {
        String email = "john@gmail.com";
        String password = "12345";
        mPresenter.login(email, password);
    }

    @Override
    public void userLogged() {
        // user has been logged
    }

    @Override
    public void onLoading(String loadingMessage) {
        // show loading
    }

    @Override
    public void onFinishLoading() {
        // hide loading
    }

    @Override
    public void onLoadingError(String title, String message) {
        // show error
    }
}
