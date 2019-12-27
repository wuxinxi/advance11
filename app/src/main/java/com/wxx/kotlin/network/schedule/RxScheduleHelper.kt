package com.wxx.kotlin.network.schedule

import com.wxx.kotlin.network.BaseModel
import com.wxx.kotlin.network.common.ApiException
import com.wxx.kotlin.network.common.MyException
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network.schedule .
 * TODO:线程调度
 */

class RxScheduleHelper {
    fun <T> ioToMain(): ObservableTransformer<BaseModel<T>, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .onErrorResumeNext(Function { t -> Observable.error(MyException.handleExcetion(t)) })
                .flatMap { model: BaseModel<T> ->
                    if (model.errorCode == 0) {
                        if (model.data == null) {
                            Observable.error(ApiException(model.errorCode, "数据结构为空"))
                        } else {
                            Observable.just(model.data)
                        }
                    } else {
                        Observable.error(ApiException(model.errorCode, model.msg))
                    }
                }.observeOn(AndroidSchedulers.mainThread())
        }
    }
}