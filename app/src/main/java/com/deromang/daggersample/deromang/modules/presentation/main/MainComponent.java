package com.deromang.daggersample.deromang.modules.presentation.main;

import com.deromang.daggersample.deromang.modules.base.scopes.PresentationScope;
import com.deromang.daggersample.presentation.main.MainPresenter;
import com.deromang.daggersample.ui.activity.MainActivity;

import dagger.Subcomponent;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
@Subcomponent(
        modules = MainModule.class
)
@PresentationScope
public interface  MainComponent {

    void inject(MainActivity mainActivity);

    MainPresenter providesMainPresenter();

    @Subcomponent.Builder
    interface Builder {

        Builder mainModule(MainModule module);

        MainComponent build();

    }

}
