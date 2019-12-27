package com.wxx.kotlin.network.common

import com.wxx.kotlin.network.ResCallBack
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author ：wuxinxi on 2019/12/26 .
 * @packages ：com.wxx.kotlin.network.common .
 * TODO:Rx解析响应
 */
class RxResponse<T>(private val callBack: ResCallBack<T>?) : Observer<T> {

    override fun onComplete() {
        println("请求结束")
    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: T) {
        callBack?.success(t)
    }

    override fun onError(e: Throwable) {
        println("失败：${e.message}")
        callBack?.fail(e)
    }

}