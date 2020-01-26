package com.deromang.daggersample.domain;

import android.os.Handler;
import android.os.Looper;

import com.deromang.daggersample.domain.tools.MainThread;
import com.deromang.daggersample.domain.tools.MainThread;

import javax.inject.Inject;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public final class MainThreadImpl implements MainThread {

    private Handler handler;

    @Inject
    public MainThreadImpl() {

        handler = new Handler(Looper.getMainLooper());

    }

    @Override
    public void runOnUi(Runnable runnable) {

        handler.post(runnable);

    }
}