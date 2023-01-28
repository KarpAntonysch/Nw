package com.example.nw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Nw)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        installSplashScreen().apply {
            this.setKeepOnScreenCondition{
                mainActivityViewModel.d()
            mainActivityViewModel.isLoading.value!!
            }
        }

    }
}