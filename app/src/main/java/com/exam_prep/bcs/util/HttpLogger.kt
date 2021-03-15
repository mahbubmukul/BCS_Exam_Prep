package com.exam_prep.bcs.util

import okhttp3.logging.HttpLoggingInterceptor

class HttpLogger : HttpLoggingInterceptor.Logger {

    companion object {
        private val TAG = HttpLogger::class.java.canonicalName
    }

    override fun log(message: String) {
        if (message != null) {
            PriyoLog.i(TAG!!, message)
        }
    }
}