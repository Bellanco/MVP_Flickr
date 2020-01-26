package com.deromang.daggersample.navigation;

import com.deromang.daggersample.domain.data.Photo;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface Navigator {

    void goToHomeScreen(Photo photo);

    void goBack();

    void goToProductScreen();

    void onBackPressed();
}