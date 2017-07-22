package com.raxdenstudios.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.raxdenstudios.mvp.presenter.IPresenter;
import com.raxdenstudios.mvp.view.IView;

/**
 * Created by Ángel Gómez.
 *
 * The view will contain a reference to the presenter. The only thing
 * that the view will do is calling a method from the presenter every time there is an interface
 * action (a button click for example).
 *
 * Lifecycle    MVPActivity             ->      Presenter
 *              onSaveInstanceState     ->      onSave
 *              onCreate                ->      onTakeView, onCreate
 *              onPostCreate            ->      onViewLoaded
 *              onResume                ->      onResume
 *              onPause                 ->      onPause
 *              onDestroy               ->      onDropView, onDestroy
 */
public abstract class MVPActivity<TPresenter extends IPresenter> extends AppCompatActivity
        implements IView {

    public TPresenter mPresenter;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            mPresenter.onSave(outState);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mPresenter == null) {
            mPresenter = initializePresenter(this);
        }
        if (mPresenter != null) {
            mPresenter.onTakeView(this);
            mPresenter.onCreate(savedInstanceState);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.onViewLoaded();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDropView();
            mPresenter.onDestroy();
        }
    }

    /**
     * Override this method to initialize Presenter for activity, if you use dagger to initialize presenter, don't worry about this method.
     *
     * @param context
     * @return
     */
    public abstract TPresenter initializePresenter(Context context);

}
