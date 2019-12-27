package com.wxx.kotlin

import android.os.Bundle
import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import com.trello.rxlifecycle3.kotlin.bindUntilEvent
import com.wxx.kotlin.network.*
import com.wxx.kotlin.network.common.RxResponse
import com.wxx.kotlin.network.schedule.RxScheduleHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Function as Function1001

class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener { test() }
    }


    private fun getData() {
        ApiClient.instance
            .getApiService()
            .getChapters()
            .compose(RxScheduleHelper().ioToMain())
            .bindUntilEvent(this, ActivityEvent.DESTROY)
            .subscribe(RxResponse(object : ResCallBack<List<Data>> {
                override fun fail(e: Throwable) {
                }

                override fun success(res: List<Data>) {
                    for (data in res) {
                        println(data)
                    }
                }
            }))

    }

    private fun getProject() {
        ApiClient.instance.getApiService()
            .getTab(1)
            .compose(RxScheduleHelper().ioToMain())
            .subscribe(RxResponse(object : ResCallBack<Article> {
                override fun success(res: Article) {
                    println(res)
                }

                override fun fail(e: Throwable) {
                    println(e.toString())
                }
            }))
    }


    fun test() {
        ApiClient.instance.getApiService()
            .getTest()
            .compose(RxScheduleHelper().ioToMain())
            .bindUntilEvent(this, ActivityEvent.DESTROY)
            .subscribe(RxResponse(object : ResCallBack<DJango> {
                override fun fail(e: Throwable) {
                    println("响应失败")
                }

                override fun success(res: DJango) {
                    println(res)
                }
            }))
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy()")
    }
}