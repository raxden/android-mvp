package com.raxdenstudios.mvp.sample.fragment;

/**
 * Created by Raxden on 03/12/2016.
 */

public interface MainFragmentView {

    void onLoading(String loadingMessage);

    void onFinishLoading();

    void onLoadingError(String title, String message);

    void userLogged();
}
