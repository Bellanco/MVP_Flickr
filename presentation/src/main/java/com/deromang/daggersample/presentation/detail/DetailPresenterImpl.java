package com.deromang.daggersample.presentation.detail;

import com.deromang.daggersample.navigation.Navigator;

import javax.inject.Inject;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public class DetailPresenterImpl implements DetailPresenter {

    private DetailView view;

    private Navigator navigator;

    @Inject
    public DetailPresenterImpl(Navigator navigator) {
        this.navigator = navigator;
    }


    @Override
    public void goBack() {
        navigator.goBack();
    }

    @Override
    public void setView(DetailView view) {
        this.view = view;
    }
}
