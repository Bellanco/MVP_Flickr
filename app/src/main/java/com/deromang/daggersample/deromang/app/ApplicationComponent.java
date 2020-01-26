package com.deromang.daggersample.deromang.app;

import com.deromang.daggersample.domain.tools.MainThread;
import com.deromang.daggersample.domain.tools.UseCaseExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
@Component(
        modules = ApplicationModule.class
)
@Singleton
public interface ApplicationComponent {

    MainThread providesMainThread();

    UseCaseExecutor providesUseCaseExecutor();

}