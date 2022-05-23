package com.example.reqresin_retrofit.repository

import com.example.reqresin_retrofit.api.RetrofitsInstance
import com.example.reqresin_retrofit.model.Post

class Repository {
    suspend fun getPost(): Post{
        return RetrofitsInstance.api.getPost()
    }
}