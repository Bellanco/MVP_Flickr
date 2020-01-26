package com.deromang.daggersample.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.deromang.daggersample.deromang.app.ApplicationComponent;
import com.deromang.daggersample.deromang.modules.base.ActivityComponent;
import com.deromang.daggersample.deromang.modules.base.ActivityModule;
import com.deromang.daggersample.deromang.modules.base.DaggerActivityComponent;
import com.deromang.daggersample.presentation.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder unbinder;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(getLayoutResId());

        unbinder = ButterKnife.bind(this);

        prepareInjection();

        initComponent();

    }

    protected ApplicationComponent getAppComponent() {
        return ((SampleApplication) getApplication()).getAppComponent();
    }

    public abstract int getLayoutResId();

    private void prepareInjection() {

        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();

    }

    @Override
    protected void onDestroy() {

        if (unbinder != null) {
            unbinder.unbind();
        }

        super.onDestroy();

    }


    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected abstract void initComponent();
}
