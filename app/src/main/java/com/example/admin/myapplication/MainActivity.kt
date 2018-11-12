package com.example.admin.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

// https://android.jlelse.eu/android-architecture-components-a-complete-kotlin-walkthrough-d59145a14bef

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
