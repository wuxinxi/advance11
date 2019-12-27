package com.wxx.kotlin.network

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network .
 * TODO:回调
 */
interface ResCallBack<T> {
    fun success(res: T)
    fun fail(e: Throwable)
}