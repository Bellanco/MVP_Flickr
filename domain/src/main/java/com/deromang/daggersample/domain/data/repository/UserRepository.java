package com.deromang.daggersample.domain.data.repository;

import com.deromang.daggersample.domain.data.Photo;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface UserRepository {

    boolean makeLogin(String username, String password);

    Photo getCurrentUser();

}
