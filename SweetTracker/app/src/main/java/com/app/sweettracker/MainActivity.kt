package com.app.sweettracker

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.app.sweettracker.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /** 롤리팝 버전 이상부터 Status bar(상태바) 색상 변경이 가능하다.
     * 마시멜로우 부터는 상태바에 있는 아이콘 색상이 변경 가능하다. */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Log.i("onCreate","check?")
        retrofitTest()

        /** 상태바 색상 변경 */
        window.statusBarColor = Color.parseColor("#039be5")

        /** 툴바 뒤로가기 버튼 아이콘 넣기 */
        setSupportActionBar(binding.toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.arrow_back_24_px)

        /** 툴바 프로젝트명 삭제 */
        val actionbar = supportActionBar
        actionbar?.setDisplayShowTitleEnabled(false)



    }

    private fun retrofitTest() {

        Log.i("retrofitTest","check?")
        var gson = GsonBuilder()
                .setLenient()
                .create()

        val builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl("https://img.sweettracker.net/")
                .addConverterFactory(GsonConverterFactory.create(gson))

        val retrofit: Retrofit = builder.build()

        val api = retrofit.create(Api::class.java)

        api.getData().enqueue(object : Callback<ResponseGetData> {
            override fun onResponse(call: Call<ResponseGetData>, response: Response<ResponseGetData>) {

                var data = response.body()

                if (response.isSuccessful) {
                    Log.d("성공: "," " + data?.trackingDetail?.get(0)?.time)
                }
            }

            override fun onFailure(call: Call<ResponseGetData>, t: Throwable) {
                Log.d("실패 : ", t.toString())
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}

