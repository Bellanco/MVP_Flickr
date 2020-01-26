package com.deromang.daggersample.domain;

import com.deromang.daggersample.domain.modules.UseCase;
import com.deromang.daggersample.domain.tools.UseCaseExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public final class UseCaseExecutorImpl implements UseCaseExecutor {


    private static final int CORE_POOL_SIZE = 1;

    private static final int MAX_POOL_SIZE = 10;

    private static final int KEEP_ALIVE_TIME = 300;

    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();

    private ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public UseCaseExecutorImpl() {
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
    }

    @Override
    public void execute(final UseCase useCase) {
        if (useCase == null) {
            throw new IllegalArgumentException("UseCase must not be null");
        }
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

}