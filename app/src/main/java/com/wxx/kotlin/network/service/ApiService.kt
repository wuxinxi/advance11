package com.wxx.kotlin.network.service

import com.wxx.kotlin.network.*
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

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

    @HTTP(method = "DELETE", path = "/mall/userCenter/cardGoodsManage", hasBody = true)
    fun delete(@Body body: DeleteBody): Observable<BaseModel<String>>

    @FormUrlEncoded
    @POST("/mall/userCenter/register")
    fun register(
        @Field("user_name") user_name: String, @Field("user_pwd") user_pwd: String,
        @Field("user_mobile") user_mobile: String, @Field("user_address") user_address: String
    ): Observable<BaseModel<Res>>


    @Multipart
    @POST("/mall/userCenter/register")
    fun register2(@PartMap body: @JvmSuppressWildcards Map<String,RequestBody>, @Part file: MultipartBody.Part): Observable<BaseModel<Res>>


}