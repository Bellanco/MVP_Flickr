package com.deromang.daggersample.deromang.modules.presentation.product;

import com.deromang.daggersample.deromang.modules.base.scopes.PresentationScope;
import com.deromang.daggersample.deromang.modules.presentation.main.MainModule;
import com.deromang.daggersample.presentation.main.MainPresenter;
import com.deromang.daggersample.presentation.product.ProductListPresenter;
import com.deromang.daggersample.ui.activity.MainActivity;
import com.deromang.daggersample.ui.product.ProductListFragment;

import dagger.Subcomponent;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
@Subcomponent(
        modules = ProductListModule.class
)
@PresentationScope
public interface ProductListComponent {

    void inject(ProductListFragment fragment);

    ProductListPresenter providesProductListPresenter();

    @Subcomponent.Builder
    interface Builder {

        Builder productListModule(ProductListModule module);

        ProductListComponent build();

    }

}
