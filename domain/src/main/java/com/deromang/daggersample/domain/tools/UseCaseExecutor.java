package com.deromang.daggersample.domain.tools;

import com.deromang.daggersample.domain.modules.UseCase;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface UseCaseExecutor {

    void execute(UseCase useCase);

}