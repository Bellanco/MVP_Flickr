package com.deromang.daggersample.domain.modules;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface UseCaseCallback<T extends UseCaseResponse> {

    void onResponse(T response);

}
