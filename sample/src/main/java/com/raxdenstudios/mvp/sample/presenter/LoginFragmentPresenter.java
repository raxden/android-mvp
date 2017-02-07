package com.raxdenstudios.mvp.sample.presenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.raxdenstudios.mvp.model.UserModel;
import com.raxdenstudios.mvp.presenter.Presenter;
import com.raxdenstudios.mvp.sample.view.LoginFragmentView;

public class LoginFragmentPresenter extends Presenter<LoginFragmentView> implements ILoginFragmentPresenter {

    private UserModel mUserModel;

    public LoginFragmentPresenter(Context context) {
        super(context);
    }

    @Override
    public void onSave(Bundle outState) {
        super.onSave(outState);
        if (outState != null) {
            outState.putParcelable(UserModel.class.getSimpleName(), mUserModel);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState
                .containsKey(UserModel.class.getSimpleName())) {
            mUserModel = savedInstanceState.getParcelable(UserModel.class.getSimpleName());
        }
    }

    @Override
    public void login(String email, String password) {
        if (validateCredentials(email, password)) {
            retrieveUserData(email, password);
        }
    }

    private void retrieveUserData(final String email, final String password) {
        mView.showLoading("loading...");

        { // this code simulate asynctask usecase...
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    mUserModel = new UserModel();
                    mUserModel.setEmail(email);
                    mUserModel.setPassword(password);
                    if (mView != null) {
                        mView.userLogged();
                        mView.hideLoading();
                    }
                }
            }, 2000);
        }
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
