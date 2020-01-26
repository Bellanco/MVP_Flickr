package com.deromang.daggersample.data;

import com.deromang.daggersample.domain.data.Photo;
import com.deromang.daggersample.domain.data.repository.UserRepository;

import javax.inject.Inject;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public class UserRepositoryImpl implements UserRepository {

    @Inject
    public UserRepositoryImpl() {
    }

    @Override
    public boolean makeLogin(String username, String password) {
        return (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"));
    }

    @Override
    public Photo getCurrentUser() {
        return new Photo();
    }
}
