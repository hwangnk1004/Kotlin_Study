package com.app.sweettracker

import retrofit2.http.GET

interface Api {

    @GET("/image/mobile_test/mobile.json")
    fun getData() : retrofit2.Call<ResponseGetData>

}