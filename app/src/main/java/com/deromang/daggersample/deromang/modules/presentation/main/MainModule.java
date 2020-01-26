package com.deromang.daggersample.deromang.modules.presentation.main;

import com.deromang.daggersample.deromang.modules.base.scopes.PresentationScope;
import com.deromang.daggersample.presentation.main.MainPresenter;
import com.deromang.daggersample.presentation.main.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
@Module
public class MainModule {

    @Provides
    @PresentationScope
    public MainPresenter providesMainPresenter(MainPresenterImpl mainPresenter) {
        return mainPresenter;
    }

}
