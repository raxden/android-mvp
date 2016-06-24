package com.raxdenstudios.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Raxden on 24/06/2016.
 */
public abstract class MVPFragment<TPresenter extends IPresenter> extends Fragment implements IView {

    private TPresenter mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (mPresenter == null) mPresenter = initializePresenter(context);
        mPresenter.onTakeView(this);
    }

    public abstract TPresenter initializePresenter(Context context);

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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSave(outState);
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

    public TPresenter getPresenter() {
        return mPresenter;
    }

}
