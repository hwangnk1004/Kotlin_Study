package com.app.sweettracker

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.app.sweettracker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /** 롤리팝 버전 이상부터 Status bar(상태바) 색상 변경이 가능하다.
     * 마시멜로우 부터는 상태바에 있는 아이콘 색상이 변경 가능하다. */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.main = this

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}

