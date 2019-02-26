package com.wearebrain.ake.activity

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import com.wearebrain.ake.context.inputMethodService

fun Activity.showKeyboard() {
    val view = currentFocus
    if (view != null) {
        inputMethodService().showSoftInput(
            view,
            InputMethodManager.SHOW_IMPLICIT
        )
    }
}

fun Activity.hideKeyboard() {
    val view = currentFocus
    if (view != null) {
        inputMethodService().hideSoftInputFromWindow(
            view.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}
