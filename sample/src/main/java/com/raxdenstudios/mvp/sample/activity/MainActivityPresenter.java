package com.raxdenstudios.mvp.sample.activity;

import android.content.Context;

import com.raxdenstudios.mvp.presenter.Presenter;

/**
 * Created by Raxden on 15/07/2016.
 */
public class MainActivityPresenter extends Presenter<MainActivityView> implements IMainActivityPresenter {

    public MainActivityPresenter(Context context) {
        super(context);
    }

    @Override
    public void login(String email, String password) {
        mView.onLoading("loading...");
        if (validateCredentials(email, password)) {
            mView.userLogged();
            mView.onFinishLoading();
        } else {
            mView.onLoadingError("error", "wrong credentials");
        }
    }

    private boolean validateCredentials(String email, String password) {
        // do validation...
        return true;
    }

}
