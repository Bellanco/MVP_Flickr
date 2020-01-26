package com.deromang.daggersample.deromang.modules.presentation.product;

import com.deromang.daggersample.deromang.modules.base.scopes.PresentationScope;
import com.deromang.daggersample.presentation.main.MainPresenter;
import com.deromang.daggersample.presentation.main.MainPresenterImpl;
import com.deromang.daggersample.presentation.product.ProductListPresenter;
import com.deromang.daggersample.presentation.product.ProductListPresenterImpl;

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
public class ProductListModule {

    @Provides
    @PresentationScope
    public ProductListPresenter providesMainPresenter(ProductListPresenterImpl presenter) {
        return presenter;
    }

}
