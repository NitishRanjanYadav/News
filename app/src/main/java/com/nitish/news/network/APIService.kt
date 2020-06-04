package com.nitish.news.network

import com.nitish.news.model.BaseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("v2/top-headlines")
    fun getNewsList(@Query("country") country: String, @Query("apiKey") apiKey: String): Observable<BaseModel>
}