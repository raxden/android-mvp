package com.raxdenstudios.mvp;

import android.os.Bundle;

import icepick.Icepick;

/**
 * Created by Raxden on 24/06/2016.
 */
public abstract class Presenter<TView extends IView> implements IPresenter<TView> {

    private TView mView;

    @Override
    public void onTakeView(TView view) {
        mView = view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void onViewLoaded() {

    }

    @Override
    public void onSave(Bundle outState) {
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDropView() {
        mView = null;
    }

    public TView getView() {
        return mView;
    }

}
