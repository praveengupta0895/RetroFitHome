package com.praveen.gupta.retrofithome.Interface;

import com.praveen.gupta.retrofithome.Model.JsonData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("data.json")
    Call<JsonData> apiCall();
}
