package com.raxdenstudios.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Raxden on 24/06/2016.
 */
public abstract class MVPActivity<TPresenter extends IPresenter> extends AppCompatActivity implements IView {

    private TPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mPresenter == null) mPresenter = initializePresenter(this);
        mPresenter.onTakeView(this);
        mPresenter.onCreate(savedInstanceState);
        mPresenter.onViewLoaded();
    }

    public abstract TPresenter initializePresenter(Context context);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSave(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDropView();
        mPresenter.onDestroy();
    }

    public TPresenter getPresenter() {
        return mPresenter;
    }

}
