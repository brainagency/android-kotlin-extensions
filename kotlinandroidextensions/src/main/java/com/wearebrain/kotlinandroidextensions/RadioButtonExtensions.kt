package com.wearebrain.kotlinandroidextensions

import android.widget.RadioButton

inline fun RadioButton.onChecked(crossinline block: () -> Unit) {
    setOnCheckedChangeListener { _, isChecked ->
        if (isChecked) {
            block.invoke()
        }
    }
}

inline fun RadioButton.onUnChecked(crossinline block: () -> Unit) {
    setOnCheckedChangeListener { _, isChecked ->
        if (!isChecked) {
            block.invoke()
        }
    }
}