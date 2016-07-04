package com.raxdenstudios.mvp;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.raxdenstudios.mvp.presenter.IPresenter;
import com.raxdenstudios.mvp.view.IView;

/**
 * Created by Raxden on 04/07/2016.
 */
public class MVPFragmentDialog<TPresenter extends IPresenter> extends DialogFragment
        implements IView {

    TPresenter mPresenter;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSave(outState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (mPresenter == null) mPresenter = initializePresenter(context);
        if (mPresenter == null) {
            throw new ClassCastException(this.getClass().toString() + " must initialize Presenter" +
                    " override initializePresenter method to init Presenter.");
        }
        mPresenter.onTakeView(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.onViewLoaded();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onDropView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    /**
     * Override this method to initialize Presenter for activity, if you use dagger to initialize
     * presenter, don't worry about this method.
     *
     * @param context
     * @return
     */
    public TPresenter initializePresenter(Context context) {
        return null;
    }

}
