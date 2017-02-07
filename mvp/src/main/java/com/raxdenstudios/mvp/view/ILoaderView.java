package com.raxdenstudios.mvp.view;

/**
 * View interface. This view is like IView but has some support methods for asynchronous data
 * loading.
 */
public interface ILoaderView extends IView {

    void showLoading(String loadingMessage);

    void hideLoading();

    void showError(String title, String message);

}
