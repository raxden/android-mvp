package com.raxdenstudios.mvp.sample.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.raxdenstudios.mvp.MVPFragment;
import com.raxdenstudios.mvp.sample.R;
import com.raxdenstudios.mvp.sample.login.presenter.LoginFragmentPresenter;

public class LoginFragment extends MVPFragment<LoginFragmentPresenter> implements ILoginFragmentView {

    private Callback mCallback;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    public interface Callback {
        void onUserLooged();
        void onError(String title, String message);
    }

    public static LoginFragment newInstance(Bundle bundle) {
        LoginFragment fragment = new LoginFragment();
        bundle = bundle == null ? new Bundle() : bundle;
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof Callback) {
            mCallback = (Callback) activity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEmailEditText = (EditText) view.findViewById(R.id.email);
        mPasswordEditText = (EditText) view.findViewById(R.id.password);
        mLoginButton = (Button) view.findViewById(R.id.login_btn);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                mPresenter.login(email, password);
            }
        });
    }

    @Override
    public LoginFragmentPresenter initializePresenter(Context context) {
        return new LoginFragmentPresenter(context);
    }

    @Override
    public void userLogged() {
        if (mCallback != null) {
            mCallback.onUserLooged();
        }
    }

    @Override
    public void showLoading(String loadingMessage) {
        mLoginButton.setText(loadingMessage);
        mLoginButton.setEnabled(false);
    }

    @Override
    public void hideLoading() {
        mLoginButton.setText("login");
        mLoginButton.setEnabled(true);
    }

    @Override
    public void showError(String title, String message) {
        if (mCallback != null) {
            mCallback.onError(title, message);
        }
    }
}
