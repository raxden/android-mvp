package com.raxdenstudios.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import com.raxdenstudios.mvp.view.IView;

/**
 * The presenter is responsible to act as the middle man between view and model. It retrieves data
 * from the model and returns it formatted to the view. But unlike the typical MVC, it also decides
 * what happens when you interact with the view. To access view, use mView.
 */
public class Presenter<TView extends IView> implements IPresenter<TView> {

    public Context mContext;
    public TView mView;

    public Presenter(Context context) {
        mContext = context;
    }

    @Override
    public void onTakeView(TView view) {
        mView = view;
    }

    /**
     * onCreate is called on every presenter’s creation.
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    /**
     * onViewLoaded is called when view is prepared and loaded. In case of activities
     * is calleb in onPostCreate and case of fragments in onActivityCreated
     */
    @Override
    public void onViewLoaded() {

    }

    /**
     * onSave is called during View’s onSaveInstanceState to persist Presenter’s state as well.
     *
     * @param outState
     */
    @Override
    public void onSave(Bundle outState) {

    }

    /**
     * onDestroy is called when user a View becomes destroyed not because of configuration change.
     */
    @Override
    public void onDestroy() {

    }

    @Override
    public void onDropView() {
        mView = null;
    }


}
