package com.app.wealthparksample.network

import com.app.wealthparksample.model.HorizontalViewModel
import com.app.wealthparksample.model.VerticalViewModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("{url}")
    fun getVerData(@Path("url") url: String): Call<List<VerticalViewModel>>

    @GET("{url}")
    fun getHorData(@Path("url") url: String): Call<List<HorizontalViewModel>>
}
