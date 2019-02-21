package com.wearebrain.androidkotlinextensions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wearebrain.kotlinandroidextensions.onUnFocused
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
