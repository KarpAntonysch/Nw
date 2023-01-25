package com.example.nw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Nw)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}