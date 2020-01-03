package com.wxx.kotlin

import android.os.Bundle
import android.os.Environment
import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import com.trello.rxlifecycle3.kotlin.bindUntilEvent
import com.wxx.kotlin.network.*
import com.wxx.kotlin.network.common.RxResponse
import com.wxx.kotlin.network.schedule.RxScheduleHelper
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import kotlin.Function as Function1001


class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener { register2() }
    }


    private fun register() {
        ApiClient.instance
            .getApiService()
            .register(
                "吴新喜" + System.currentTimeMillis(),
                "1895895" + System.currentTimeMillis(),
                "15454" + System.currentTimeMillis(),
                "安徽亳州"
            )
            .compose(RxScheduleHelper().ioToMain())
            .bindUntilEvent(this, ActivityEvent.DESTROY)
            .subscribe(RxResponse(object : ResCallBack<Res> {
                override fun success(res: Res) {
                    println(res.toString())
                }

                override fun fail(e: Throwable) {
                    println("失败")
                }

            }))
    }

    private fun register2() {
        println(Environment.getExternalStorageDirectory().absolutePath)
        val file = File(
            Environment.getExternalStorageDirectory().absolutePath + "/DCIM/Camera/IMG_20200103_150242.jpg"
        )

        if (file.exists()) {
            println("图片存在：${file}")
        } else {
            println("文件不存在${file}")
            return
        }
        val type = MediaType.parse("text/plain")
        val map: HashMap<String, RequestBody> = HashMap()
        map["user_mobile"] = RequestBody.create(type, "吴新喜" + System.currentTimeMillis())
        map["user_name"] = RequestBody.create(type, "吴新喜" + System.currentTimeMillis())
        map["user_pwd"] = RequestBody.create(type, "吴新喜" + System.currentTimeMillis())

        val requestBody: RequestBody = RequestBody.create(MediaType.parse("image/jpg"), file)
        val filePart = MultipartBody.Part.createFormData("user_icon", file.name, requestBody)
        ApiClient.instance
            .getApiService()
            .register2(map, filePart)
            .compose(RxScheduleHelper().ioToMain())
            .bindUntilEvent(this, ActivityEvent.DESTROY)
            .subscribe(RxResponse(object : ResCallBack<Res> {
                override fun success(res: Res) {
                    println(res.toString())
                }

                override fun fail(e: Throwable) {
                    println("失败")
                }

            }))
    }

    private fun delete() {
        val i = intArrayOf(24, 21, 16)
        ApiClient.instance
            .getApiService()
            .delete(DeleteBody("18682188964", i))
            .compose(RxScheduleHelper().ioToMain())
            .bindUntilEvent(this, ActivityEvent.DESTROY)
            .subscribe(RxResponse(object : ResCallBack<String> {
                override fun fail(e: Throwable) {
                    println(e.message)
                }

                override fun success(res: String) {
                    println(res)
                }
            }))
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