package com.raxdenstudios.mvp.sample.controler;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.raxdenstudios.mvp.sample.R;
import com.raxdenstudios.mvp.sample.view.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentCallback {

    private MainFragment mMainFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            mMainFragment = MainFragment.newInstance(getIntent().getExtras());
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, mMainFragment, MainFragment.class.getSimpleName())
                    .commit();
        } else {
            mMainFragment = (MainFragment) getFragmentManager().findFragmentById(R.id.content);
        }
    }

    @Override
    public void onUserLooged() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("User logged")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.show();
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
