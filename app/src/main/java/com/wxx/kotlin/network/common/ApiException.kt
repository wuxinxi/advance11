package com.wxx.kotlin.network.common

/**
 * @author ：wuxinxi on 2019/12/25 .
 * @packages ：com.wxx.kotlin.network.common .
 * TODO:一句话描述
 */
class ApiException(msg: String, cause: Throwable?) : Exception(msg, cause) {
    var errorCode: Int = -1
    var errorMsg: String? = null
    var errorCause: Throwable? = null


    constructor(errorCode: Int, errorMsg: String, errorCause: Throwable?) : this(errorMsg, errorCause) {
        this.errorCode = errorCode
        this.errorMsg = errorMsg
        this.errorCause = errorCause
    }

    constructor(errorCode: Int, errorMsg: String) : this(errorCode, errorMsg, Throwable()) {
        this.errorCode = errorCode
        this.errorMsg = errorMsg
    }

    fun errorMsg(errorMsg: String) {
        this.errorMsg = errorMsg
    }

    fun errorCode(errorCode: Int) {
        this.errorCode = errorCode
    }

}