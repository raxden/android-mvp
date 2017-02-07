package com.raxdenstudios.mvp.sample.controler;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.raxdenstudios.mvp.sample.R;
import com.raxdenstudios.mvp.sample.view.LoginFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.MainFragmentCallback {

    private LoginFragment mMainFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        if (savedInstanceState == null) {
            mMainFragment = LoginFragment.newInstance(getIntent().getExtras());
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, mMainFragment, LoginFragment.class.getSimpleName())
                    .commit();
        } else {
            mMainFragment = (LoginFragment) getFragmentManager().findFragmentById(R.id.content);
        }
    }

    @Override
    public void onUserLooged() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("UserModel logged")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.show();
        // Go to another activity that requires a user logged.
    }

    @Override
    public void onError(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.show();
    }

}
