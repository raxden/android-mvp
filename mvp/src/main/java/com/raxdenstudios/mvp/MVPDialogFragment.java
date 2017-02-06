package com.raxdenstudios.mvp;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.raxdenstudios.mvp.presenter.IPresenter;
import com.raxdenstudios.mvp.view.IView;

/**
 * The view will contain a reference to the presenter. The only thing
 * that the view will do is calling a method from the presenter every time there is an interface
 * action (a button click for example).
 *
 * Lifecycle    MVPFragment             ->      Presenter
 *              onSaveInstanceState     ->      onSave
 *              onAttach                ->      onTakeView
 *              onCreate                ->      onCreate
 *              onActivityCreated       ->      onViewLoaded
 *              onResume                ->      onResume
 *              onPause                 ->      onPause
 *              onDestroyView           ->      onDropView
 *              onDestroy               ->      onDestroy
 */
public abstract class MVPDialogFragment<TPresenter extends IPresenter> extends DialogFragment
        implements IView {

    public TPresenter mPresenter;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSave(outState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (mPresenter == null) {
            mPresenter = initializePresenter(activity);
        }
        if (mPresenter != null) {
            mPresenter.onTakeView(this);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (mPresenter == null) {
            mPresenter = initializePresenter(context);
        }
        if (mPresenter != null) {
            mPresenter.onTakeView(this);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.onViewLoaded();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onPause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDropView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    /**
     * Override this method to initialize Presenter for activity, if you use dagger to initialize
     * presenter, don't worry about this method.
     *
     * @param context
     * @return
     */
    public abstract TPresenter initializePresenter(Context context);

}
