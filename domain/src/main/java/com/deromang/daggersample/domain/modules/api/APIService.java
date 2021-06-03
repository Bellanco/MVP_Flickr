package com.deromang.daggersample.domain.modules.api;

import com.deromang.daggersample.domain.data.ResponsePhoto;
import com.deromang.daggersample.domain.data.detail.PhotoDetailResponseModel;
import com.deromang.daggersample.domain.data.url.UrlDetailResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("rest/?")
    Call<ResponsePhoto> listPhotos(@Query("method") String method,
                                   @Query("api_key") String apiKey,
                                   @Query("text") String text,
                                   @Query("format") String format,
                                   @Query("nojsoncallback") int jsonCallback,
                                   @Query("extras") String extras);


    @GET("rest/?")
    Call<PhotoDetailResponseModel> detailPhoto(@Query("method") String method,
                                               @Query("api_key") String apiKey,
                                               @Query("photo_id") String idPhoto,
                                               @Query("secret") String secret,
                                               @Query("format") String format,
                                               @Query("nojsoncallback") int jsonCallback);

    @GET("rest/?")
    Call<UrlDetailResponseModel> urlPhoto(@Query("method") String method,
                                          @Query("api_key") String apiKey,
                                          @Query("photo_id") String idPhoto,
                                          @Query("format") String format,
                                          @Query("nojsoncallback") int jsonCallback);


}
