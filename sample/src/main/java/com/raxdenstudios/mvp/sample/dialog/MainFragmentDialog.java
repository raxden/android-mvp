package com.raxdenstudios.mvp.sample.dialog;

import android.content.Context;

/**
 * Created by Raxden on 03/12/2016.
 */

public class MainFragmentDialog extends BaseFragmentDialog<MainFragmentDialogPresenter> {

    @Override
    public MainFragmentDialogPresenter initializePresenter(Context context) {
        return new MainFragmentDialogPresenter(context);
    }

}
