package com.deromang.daggersample.deromang.modules.presentation.main;

import com.deromang.daggersample.deromang.modules.base.scopes.PresentationScope;
import com.deromang.daggersample.presentation.detail.DetailPresenter;
import com.deromang.daggersample.ui.detail.DetailFragment;

import dagger.Subcomponent;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
@Subcomponent(
        modules = DetailModule.class
)
@PresentationScope
public interface DetailComponent {

    void inject(DetailFragment mainActivity);

    DetailPresenter providesDetailPresenter();

    @Subcomponent.Builder
    interface Builder {

        Builder detailModule(DetailModule module);

        DetailComponent build();

    }

}
