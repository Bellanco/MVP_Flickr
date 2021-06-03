package com.deromang.daggersample.presentation.detail;

import com.deromang.daggersample.domain.data.Constants;
import com.deromang.daggersample.domain.data.detail.PhotoDetailResponseModel;
import com.deromang.daggersample.domain.data.url.UrlDetailResponseModel;
import com.deromang.daggersample.domain.modules.api.APIClient;
import com.deromang.daggersample.domain.modules.api.APIService;
import com.deromang.daggersample.navigation.Navigator;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class Description.
 *
 * @author deromang.
 * @version 1.0.
 * @since 26/1/20.
 */
public class DetailPresenterImpl implements DetailPresenter {

    private DetailView view;

    private Navigator navigator;

    private APIService mApiService;

    @Inject
    public DetailPresenterImpl(Navigator navigator) {
        this.navigator = navigator;
    }


    @Override
    public void goBack() {
        navigator.goBack();
    }

    @Override
    public void setView(DetailView view) {
        this.view = view;
    }


    @Override
    public void requestData() {
        mApiService = APIClient.getAPIService();
    }

    @Override
    public void getDetailImage(String idPhoto, String secretNumber) {
        mApiService.detailPhoto(Constants.METHOD_DETAIL, Constants.API_KEY, idPhoto, secretNumber, Constants.FORMAT, 1).enqueue(new Callback<PhotoDetailResponseModel>() {
            @Override
            public void onResponse(Call<PhotoDetailResponseModel> call, Response<PhotoDetailResponseModel> response) {
                if (response.body() != null && response.body().getPhoto() != null) {
                    view.showDetailPhoto(response.body().getPhoto());
                } else
                    view.showError(response.message());
            }

            @Override
            public void onFailure(Call<PhotoDetailResponseModel> call, Throwable throwable) {
                view.showError(null);
            }
        });
    }

    @Override
    public void getUrlImage(String idPhoto) {
        mApiService.urlPhoto(Constants.METHOD_URL, Constants.API_KEY, idPhoto, Constants.FORMAT, 1).enqueue(new Callback<UrlDetailResponseModel>() {
            @Override
            public void onResponse(Call<UrlDetailResponseModel> call, Response<UrlDetailResponseModel> response) {
                if (response.body() != null && response.body().getSizes() != null && response.body().getSizes().getSize() != null) {
                    view.showImages(response.body().getSizes().getSize());
                } else {
                    view.showError(response.message());
                }
            }

            @Override
            public void onFailure(Call<UrlDetailResponseModel> call, Throwable throwable) {
                view.showError(null);
            }
        });
    }
}
