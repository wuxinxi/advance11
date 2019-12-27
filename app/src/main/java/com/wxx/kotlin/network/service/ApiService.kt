package com.wxx.kotlin.network.service

import com.wxx.kotlin.network.Article
import com.wxx.kotlin.network.BaseModel
import com.wxx.kotlin.network.DJango
import com.wxx.kotlin.network.Data
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network .
 * TODO:一句话描述
 */

interface ApiService {
    @GET("/wxarticle/chapters/json")
    fun getChapters(): Observable<BaseModel<List<Data>>>


    @GET("/article/listproject/{id}/json")
    fun getTab(@Path("id") id: Int): Observable<BaseModel<Article>>

    @GET("/request/request")
    fun getTest(): Observable<BaseModel<DJango>>
}