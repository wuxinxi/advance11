package com.wxx.kotlin.network

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network .
 * TODO:一句话描述
 */
open class BaseModel<T>(var errorCode: Int=-1, val msg: String, val data: T?)