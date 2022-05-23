package com.example.reqresin.api;

import com.example.reqresin.data.User;
import com.example.reqresin.data.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {
    @GET("users")
    Call<UserList> getUsersList();

    @GET("users")
    Call<UserList> getUser();

    @POST("users")
    Call<User> createUser(@Body User user);
}
