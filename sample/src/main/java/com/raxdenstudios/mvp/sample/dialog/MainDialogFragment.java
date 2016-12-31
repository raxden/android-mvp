package com.raxdenstudios.mvp.sample.dialog;

import android.content.Context;

/**
 * Created by Raxden on 03/12/2016.
 */

public class MainDialogFragment extends BaseDialogFragment<MainFragmentDialogPresenter> {

    @Override
    public MainFragmentDialogPresenter initializePresenter(Context context) {
        return new MainFragmentDialogPresenter(context);
    }

}
