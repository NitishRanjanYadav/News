package com.nitish.doubtnutassignment.network

import com.nitish.doubtnutassignment.model.BaseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("v2/top-headlines")
    fun getNewsList(@Query("country") country: String, @Query("apiKey") apiKey: String): Observable<BaseModel>
}