package com.deromang.daggersample.domain.tools;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface MainThread {

    void runOnUi(Runnable runnable);

}