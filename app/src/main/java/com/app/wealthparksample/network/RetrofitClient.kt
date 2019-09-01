package com.app.wealthparksample.network

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val TAG: String = "RetrofitClient"
    private const val BASE_URL: String = "https://s3-ap-northeast-1.amazonaws.com/"
    private var mRetrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null

    /**
     * Build and return the Retrofit Object.
     * @return
     */
    val client: Retrofit?
        get() {
            if (okHttpClient == null) {
                initOkHttp()
            }

            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient!!)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return mRetrofit
        }

    /**
     * Helps to customize the httpClient.
     */
    private fun initOkHttp() {
        val REQUEST_TIMEOUT = 10
        val httpClient = OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClient = httpClient.build()
    }
}
