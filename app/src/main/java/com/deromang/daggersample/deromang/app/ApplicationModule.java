package com.deromang.daggersample.deromang.app;

import com.deromang.daggersample.domain.tools.MainThread;
import com.deromang.daggersample.domain.MainThreadImpl;
import com.deromang.daggersample.domain.tools.UseCaseExecutor;
import com.deromang.daggersample.domain.UseCaseExecutorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public MainThread providesMainThread(MainThreadImpl mainThread) {
        return mainThread;
    }

    @Provides
    @Singleton
    public UseCaseExecutor providesUseCaseExecutor(UseCaseExecutorImpl useCaseExecutor) {
        return useCaseExecutor;
    }

}
