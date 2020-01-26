package com.deromang.daggersample.presentation.main;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface MainPresenter {

    void setView(MainView view);

    void initialize();

    void onBackPressed();
}
