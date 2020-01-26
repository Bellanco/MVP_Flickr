package com.deromang.daggersample.presentation.main;

import com.deromang.daggersample.navigation.Navigator;

import javax.inject.Inject;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView view;

    private Navigator navigator;

    @Inject
    public MainPresenterImpl(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void setView(MainView view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        navigator.goToProductScreen();
    }

    @Override
    public void onBackPressed() {
        navigator.onBackPressed();
    }

}
