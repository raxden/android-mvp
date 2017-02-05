package com.raxdenstudios.mvp.sample.dialog;

/**
 * Created by Raxden on 03/12/2016.
 */

public interface MainFragmentDialogView {

    void onLoading(String loadingMessage);

    void onFinishLoading();

    void onLoadingError(String title, String message);

    void userLogged();

}
