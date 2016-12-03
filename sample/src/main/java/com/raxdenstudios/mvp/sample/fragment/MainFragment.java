package com.raxdenstudios.mvp.sample.fragment;

import android.content.Context;

/**
 * Created by Raxden on 03/12/2016.
 */

public class MainFragment extends BaseFragment<MainFragmentPresenter> {

    @Override
    public MainFragmentPresenter initializePresenter(Context context) {
        return new MainFragmentPresenter(context);
    }

}
