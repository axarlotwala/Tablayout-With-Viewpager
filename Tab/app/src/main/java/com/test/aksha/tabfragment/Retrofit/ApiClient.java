package com.test.aksha.tabfragment.Retrofit;

import com.test.aksha.tabfragment.Model.Category_model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiClient {

    @FormUrlEncoded
    @POST("fetchCategoryName")
    Call<Category_model> getCategoryName(@Field("token") String AccessToken);
}
