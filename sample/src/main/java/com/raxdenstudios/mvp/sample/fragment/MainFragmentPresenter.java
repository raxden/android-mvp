package com.raxdenstudios.mvp.sample.fragment;

import android.content.Context;

import com.raxdenstudios.mvp.presenter.Presenter;

/**
 * Created by Raxden on 03/12/2016.
 */

public class MainFragmentPresenter extends Presenter<MainFragmentView> implements IMainFragmentPresenter {

    public MainFragmentPresenter(Context context) {
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
