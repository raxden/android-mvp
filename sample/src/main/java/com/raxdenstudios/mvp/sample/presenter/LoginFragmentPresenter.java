package com.raxdenstudios.mvp.sample.presenter;

import android.content.Context;
import android.os.Handler;

import com.raxdenstudios.mvp.presenter.Presenter;
import com.raxdenstudios.mvp.sample.view.LoginFragmentView;

public class LoginFragmentPresenter extends Presenter<LoginFragmentView> implements ILoginFragmentPresenter {

    public LoginFragmentPresenter(Context context) {
        super(context);
    }

    @Override
    public void login(String email, String password) {
        if (validateCredentials(email, password)) {
            retrieveUserData(email, password);
        }
    }

    private void retrieveUserData(String email, String password) {
        mView.showLoading("loading...");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (mView != null) {
                    mView.userLogged();
                    mView.hideLoading();
                }
            }
        }, 2000);
    }

    private boolean validateCredentials(String email, String password) {
        if (email == null || email.length() == 0) {
            mView.showError("error", "email empty");
            return false;
        }
        if (password == null || password.length() == 0) {
            mView.showError("error", "password empty");
            return false;
        }
        return true;
    }

}
