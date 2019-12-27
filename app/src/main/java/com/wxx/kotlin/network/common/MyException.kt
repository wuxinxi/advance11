package com.wxx.kotlin.network.common

import android.nfc.FormatException
import com.alibaba.fastjson.JSONException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network.common .
 * TODO:一句话描述
 */
class MyException {
    companion object {
        fun handleExcetion(e: Throwable): ApiException {
            if (e is HttpException) {
                val ex = ApiException(e.code(), e.message(), e.cause)
                when (ex.errorCode) {
                    401 -> ex.errorMsg("未授权的请求")
                    403 -> ex.errorMsg("禁止访问")
                    404 -> ex.errorMsg("服务未找到")
                    408 -> ex.errorMsg("请求超时")
                    500 -> ex.errorMsg("服务异常")
                    502 -> ex.errorMsg("无效的请求")
                    504 -> ex.errorMsg("网关响应超时")
                    302 -> ex.errorMsg("网络错误")
                    9999 -> ex.errorMsg("接口异常")
                }
                return ex
            } else if (e is JSONException) {
                return ApiException(-100, "解析错误", e)
            } else if (e is SocketTimeoutException) {
                return ApiException(-101, "连接超时", e)
            } else if (e is ClassCastException) {
                return ApiException(-102, "类型转换异常", e)
            } else if (e is NullPointerException) {
                return ApiException(-103, "数据空指针", e)
            } else if (e is FormatException) {
                return ApiException(-104, "数据格式异常", e)
            } else if (e is UnknownHostException) {
                return ApiException(-105, "服务器地址错误", e)
            } else {
                return ApiException(-107, e.toString(), e)
            }
        }
    }
}