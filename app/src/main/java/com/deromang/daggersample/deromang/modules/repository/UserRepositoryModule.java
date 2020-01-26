package com.deromang.daggersample.deromang.modules.repository;

import com.deromang.daggersample.data.UserRepositoryImpl;
import com.deromang.daggersample.deromang.modules.base.scopes.PresentationScope;
import com.deromang.daggersample.domain.data.repository.UserRepository;

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
public class UserRepositoryModule {

    @Provides
    @PresentationScope
    public UserRepository providesUserRepository(UserRepositoryImpl userRepository){
        return userRepository;
    }

}
