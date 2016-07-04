package com.raxdenstudios.mvp.view;

/**
 * Created by Raxden on 04/07/2016.
 */
public interface ILoaderView extends IView {

    void onStartLoader();

    void onFinishLoader();

    void onError(String message);

    void onError(String message, Throwable throwable);

}
