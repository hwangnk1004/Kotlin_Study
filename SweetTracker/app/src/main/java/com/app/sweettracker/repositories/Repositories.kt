package com.app.sweettracker.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.sweettracker.ResponseGetData
import com.app.sweettracker.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repositories {

    fun getData(): MutableLiveData<ResponseGetData> {
        val dataResponse = MutableLiveData<ResponseGetData>()

        Api().getData().enqueue(object : Callback<ResponseGetData> {
            override fun onResponse(
                call: Call<ResponseGetData>,
                response: Response<ResponseGetData>
            ) {

                if (response.isSuccessful) {

                    dataResponse.value = response.body()
                    Log.d("성공: ", " " + dataResponse.value?.trackingDetail?.get(0)?.where)

                }
            }

            override fun onFailure(call: Call<ResponseGetData>, t: Throwable) {
                Log.d("실패 : ", t.toString())
            }
        })


        return dataResponse
    }

}