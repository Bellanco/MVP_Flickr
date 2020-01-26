package com.deromang.daggersample.domain.modules.api;

import com.deromang.daggersample.domain.data.ResponsePhoto;

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


}
