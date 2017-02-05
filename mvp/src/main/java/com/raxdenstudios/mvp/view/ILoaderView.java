package com.raxdenstudios.mvp.view;

/**
 * Created by Raxden on 04/07/2016.
 */
public interface ILoaderView extends IView {

    void onLoading(String loadingMessage);

    void onFinishLoading();

    void onLoadingError(String title, String message);

}
