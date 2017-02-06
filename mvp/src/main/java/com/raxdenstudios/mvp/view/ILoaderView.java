package com.raxdenstudios.mvp.view;

/**
 * View interface. This view is like IView but has some support methods for asynchronous data
 * loading.
 */
public interface ILoaderView extends IView {

    void onLoading(String loadingMessage);

    void onFinishLoading();

    void onLoadingError(String title, String message);

}
