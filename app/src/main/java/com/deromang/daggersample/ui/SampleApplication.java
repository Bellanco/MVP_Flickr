package com.deromang.daggersample.ui;

import android.app.Application;

import com.deromang.daggersample.deromang.app.ApplicationComponent;
import com.deromang.daggersample.deromang.app.ApplicationModule;
import com.deromang.daggersample.deromang.app.DaggerApplicationComponent;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public final class SampleApplication extends Application {

    ApplicationComponent appComponent;

    @Override
    public void onCreate() {

        super.onCreate();

        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();

    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

}