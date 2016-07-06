package com.raxdenstudios.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.raxdenstudios.mvp.presenter.IPresenter;
import com.raxdenstudios.mvp.view.IView;

/**
 * Created by Raxden on 24/06/2016.
 */
public abstract class MVPActivity<TPresenter extends IPresenter> extends AppCompatActivity
        implements IView {

    TPresenter mPresenter;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSave(outState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mPresenter == null) {
            mPresenter = initializePresenter(this);
        }
        if (mPresenter == null) {
            throw new ClassCastException(this.getClass().toString() + " must initialize Presenter override initializePresenter method to init Presenter.");
        }
        mPresenter.onTakeView(this);
        mPresenter.onCreate(savedInstanceState);
        mPresenter.onViewLoaded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDropView();
        mPresenter.onDestroy();
    }

    /**
     * Override this method to initialize Presenter for activity, if you use dagger to initialize presenter, don't worry about this method.
     *
     * @param context
     * @return
     */
    public abstract TPresenter initializePresenter(Context context);

}
