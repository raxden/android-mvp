package com.raxdenstudios.mvp.sample.fragment;

import android.content.Context;

import com.raxdenstudios.mvp.MVPFragment;

/**
 * Created by Raxden on 03/12/2016.
 */

public class MainFragment extends MVPFragment<MainFragmentPresenter> implements MainFragmentView {

    @Override
    public MainFragmentPresenter initializePresenter(Context context) {
        return new MainFragmentPresenter(context);
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
