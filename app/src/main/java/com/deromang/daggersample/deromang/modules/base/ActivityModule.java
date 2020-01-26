package com.deromang.daggersample.deromang.modules.base;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.deromang.daggersample.deromang.modules.base.scopes.ActivityScope;
import com.deromang.daggersample.deromang.modules.presentation.main.MainComponent;
import com.deromang.daggersample.navigation.Navigator;
import com.deromang.daggersample.navigation.NavigatorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
@Module(
        subcomponents = {
                MainComponent.class,
        }
)
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Navigator providesNavigator() {
        return new NavigatorImpl(activity);
    }

}
