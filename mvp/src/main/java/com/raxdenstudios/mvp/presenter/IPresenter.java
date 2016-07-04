package com.raxdenstudios.mvp.presenter;

import android.os.Bundle;

import com.raxdenstudios.mvp.view.IView;

/**
 * Created by Raxden on 24/06/2016.
 */
public interface IPresenter<TView extends IView> {

    /**
     * Called when view is attached to Presenter
     *
     * @param view
     */
    void onTakeView(TView view);

    /**
     * Called on every presenter's creation.
     *
     * @param savedState
     */
    void onCreate(Bundle savedState);

    /**
     * Called when view has been loaded.
     *
     */
    void onViewLoaded();

    /**
     * Called during View's onSaveInstanceState to persist Presenter's state as well.
     *
     * @param outState
     */
    void onSave(Bundle outState);

    /**
     * Called when user a View becomes destroyed not because of configuration change
     */
    void onDestroy();

    /**
     * Called during Activity's onDestroy() or Fragment's onDestroyView(), or during android.view.View#onDetachedFromWindow()
     */
    void onDropView();

}
