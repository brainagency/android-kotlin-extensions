package com.wearebrain.ake.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wearebrain.ake.view.onFocused
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.onFocused {  }
    }
}
