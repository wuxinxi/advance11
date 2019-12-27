package com.wxx.kotlin.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network .
 * TODO:一句话描述
 */

class InternaleOkhttpClient {
    companion object {
        @JvmStatic
        fun getOkHttpClient(): OkHttpClient {
            var okHttpClient: OkHttpClient? = null
            if (okHttpClient == null) {
                okHttpClient = OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .build()
            }
            return okHttpClient!!
        }
    }
}