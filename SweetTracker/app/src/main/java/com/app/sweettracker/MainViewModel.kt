package com.app.sweettracker

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.sweettracker.repositories.Repositories
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel : ViewModel() {

    var dataRe = MutableLiveData<String>()



    fun startRetrofit() {

        val dataResponse = Repositories().getData()
        Log.d("start",dataResponse.value?.parcelCompanyName+" ")

    }




}


