package com.app.wealthparksample.util

import android.util.Log

/**
 * Class contains logger methods and helpful for debugging purpose.
 */
object PrintLog {
    private val TAG: String = "MLog->"
    //Print log only in debug mode
    private val debug: Boolean = true

    fun d(tag: String, msg: String) {
        if (debug)
            Log.d(TAG + tag, msg)
    }

    fun i(tag: String, msg: String) {
        if (debug)
            Log.i(TAG + tag, msg)
    }

    fun e(tag: String, msg: String) {
        Log.e(TAG + tag, msg)
    }

    fun e(tag: String, msg: String, tr: Throwable) {
        Log.e(TAG, "e: ", tr)
    }

    fun v(tag: String, msg: String) {
        if (debug)
            Log.v(TAG + tag, msg)
    }

    fun w(tag: String, msg: String) {
        Log.w(TAG + tag, msg)
    }
}

