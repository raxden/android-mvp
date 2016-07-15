package com.raxdenstudios.mvp.presenter;

import android.os.Bundle;

import com.raxdenstudios.mvp.view.IView;

/**
 * Created by Raxden on 24/06/2016.
 */
public class Presenter<TView extends IView> implements IPresenter<TView> {

    public TView mView;

    @Override
    public void onTakeView(TView view) {
        mView = view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onViewLoaded() {

    }

    @Override
    public void onSave(Bundle outState) {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onDropView() {
        mView = null;
    }

}
