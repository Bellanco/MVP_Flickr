package com.deromang.daggersample.navigation;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.deromang.daggersample.R;
import com.deromang.daggersample.domain.data.Photo;
import com.deromang.daggersample.ui.activity.MainActivity;
import com.deromang.daggersample.ui.detail.DetailFragment;
import com.deromang.daggersample.ui.product.ProductListFragment;


/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public class NavigatorImpl implements Navigator {

    public final static int CONTAINER_ID = R.id.container;


    private AppCompatActivity activity;

    public NavigatorImpl(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void goToHomeScreen(Photo photo) {

        activity.getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        replaceFragment(DetailFragment.newInstance(photo), true);


    }

    @Override
    public void goBack() {
        Intent intent = new Intent(activity, MainActivity.class);

        activity.startActivity(intent);

    }

    @Override
    public void goToProductScreen() {
        activity.getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        replaceFragment(ProductListFragment.newInstance(), false);

    }

    @Override
    public void onBackPressed() {
        activity.getSupportFragmentManager().popBackStackImmediate();
    }

    private void replaceFragment(Fragment fragment, boolean addToBack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (addToBack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.replace(CONTAINER_ID, fragment);
        fragmentTransaction.commit();
    }


}