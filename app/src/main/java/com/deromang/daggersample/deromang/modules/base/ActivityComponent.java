package com.deromang.daggersample.deromang.modules.base;

import com.deromang.daggersample.deromang.app.ApplicationComponent;
import com.deromang.daggersample.deromang.modules.presentation.main.DetailComponent;
import com.deromang.daggersample.deromang.modules.presentation.main.MainComponent;
import com.deromang.daggersample.deromang.modules.base.scopes.ActivityScope;
import com.deromang.daggersample.deromang.modules.presentation.product.ProductListComponent;
import com.deromang.daggersample.navigation.Navigator;

import dagger.Component;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
@Component(
        modules = {
                ActivityModule.class,
        },
        dependencies = ApplicationComponent.class
)
@ActivityScope
public interface ActivityComponent {

    Navigator providesNavigator();

    MainComponent.Builder mainComponent();

    DetailComponent.Builder detailComponent();

    ProductListComponent.Builder productListComponent();
}
