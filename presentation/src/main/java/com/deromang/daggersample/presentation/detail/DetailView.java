package com.deromang.daggersample.presentation.detail;

import com.deromang.daggersample.domain.data.detail.PhotoDetailResponseModel;
import com.deromang.daggersample.domain.data.detail.PhotoModel;
import com.deromang.daggersample.domain.data.url.Size;

import java.util.List;

import retrofit2.Response;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public interface DetailView {

    void showDetailPhoto(PhotoModel photo);

    void showError(String message);

    void showImages(List<Size> size);
}
