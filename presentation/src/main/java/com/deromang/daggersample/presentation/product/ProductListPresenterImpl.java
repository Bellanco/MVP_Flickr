package com.deromang.daggersample.presentation.product;

import com.deromang.daggersample.domain.data.Constants;
import com.deromang.daggersample.domain.data.Photo;
import com.deromang.daggersample.domain.data.ResponsePhoto;
import com.deromang.daggersample.domain.modules.api.APIClient;
import com.deromang.daggersample.domain.modules.api.APIService;
import com.deromang.daggersample.navigation.Navigator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.deromang.daggersample.domain.data.Constants.EXTRAS;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public class ProductListPresenterImpl implements ProductListPresenter {

    private ProductListView view;

    private Navigator navigator;

    private APIService mApiService;

    private List<Photo> photoList;

    @Inject
    public ProductListPresenterImpl(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void setView(ProductListView view) {
        this.view = view;

    }

    public void goToDetails(Photo photo) {
        navigator.goToHomeScreen(photo);
    }

    @Override
    public void requestData() {
        mApiService = APIClient.getAPIService();
    }

    @Override
    public void onTextChanged(CharSequence value) {
        mApiService.listPhotos(Constants.METHOD_SEARCH, Constants.API_KEY, String.valueOf(value), Constants.FORMAT, 1, EXTRAS).enqueue(new Callback<ResponsePhoto>() {
            @Override
            public void onResponse(Call<ResponsePhoto> call, Response<ResponsePhoto> response) {
                if (response.body() != null && response.body().getPhotos() != null) {
                    photoList = response.body().getPhotos().getPhoto();
                } else
                    photoList = new ArrayList<>();
                view.notifyDataSetChanged(photoList);
            }

            @Override
            public void onFailure(Call<ResponsePhoto> call, Throwable throwable) {
                navigator.goToProductScreen();
            }
        });

    }
}
