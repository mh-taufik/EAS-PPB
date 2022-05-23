package com.example.reqresin_retrofit.api

import com.example.reqresin_retrofit.model.Post
import retrofit2.http.GET

interface SimpleApi {
    @GET("users/1")
    suspend fun getPost(): Post
}