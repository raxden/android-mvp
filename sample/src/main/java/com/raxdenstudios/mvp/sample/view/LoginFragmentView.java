package com.raxdenstudios.mvp.sample.view;

import com.raxdenstudios.mvp.view.ILoaderView;

public interface LoginFragmentView extends IView {
    void showLoading(String loadingMessage);
    void hideLoading();
    void showError(String title, String message);
    void userLogged();
}
