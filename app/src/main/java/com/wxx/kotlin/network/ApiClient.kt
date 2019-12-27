package com.wxx.kotlin.network

import com.wxx.kotlin.network.service.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network .
 * TODO:一句话描述
 */

class ApiClient {
//    private val BASE_URL = "http://wanandroid.com"
    private val BASE_URL = "http://192.168.1.70"
    private var retrofit: Retrofit? = null

    init {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(InternaleOkhttpClient.getOkHttpClient())
            .build()
    }


    private var apiService: ApiService? = null

    companion object {
        val instance: ApiClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ApiClient()
        }
    }

    fun getApiService(): ApiService {
        return if (apiService == null) retrofit!!.create(ApiService::class.java) else apiService!!
    }
}