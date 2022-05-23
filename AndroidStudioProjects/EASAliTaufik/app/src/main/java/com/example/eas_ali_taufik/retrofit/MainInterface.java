package com.example.eas_ali_taufik.retrofit;

import androidx.lifecycle.LiveData;

import com.example.eas_ali_taufik.pojo.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainInterface {
    @GET("v2/top-headlines?country=id&apiKey=6ecdf12167e0469f92cd2f06d2ee4108")
    Call<NewsResponse> getAllNews();
}
