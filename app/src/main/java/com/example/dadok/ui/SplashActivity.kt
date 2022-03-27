package com.example.dadok.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dadok.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //뷰모델 실행 및 데이터 업데이트
        initViewModel()
        observeSplashLiveData()
    }

    private fun initViewModel() {
        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]
    }

    private fun observeSplashLiveData() {
        splashViewModel.initSplashScreen()
        splashViewModel.liveData.observe(this, Observer<Boolean> {
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}