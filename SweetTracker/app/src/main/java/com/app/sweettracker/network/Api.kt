package com.app.sweettracker.network

import com.app.sweettracker.ResponseGetData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {

    @GET("/image/mobile_test/mobile.json")
     fun getData() : Call<ResponseGetData>

    companion object {
        operator fun invoke() : Api{
            return Retrofit.Builder()
                .baseUrl("https://img.sweettracker.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }

}