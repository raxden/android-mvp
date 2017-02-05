package com.raxdenstudios.mvp.sample.activity;

/**
 * Created by Raxden on 15/07/2016.
 */
public interface MainActivityView {

    void onLoading(String loadingMessage);

    void onFinishLoading();

    void onLoadingError(String title, String message);

    void userLogged();

}
