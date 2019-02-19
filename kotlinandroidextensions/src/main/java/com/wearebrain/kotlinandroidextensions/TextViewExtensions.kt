package com.wearebrain.kotlinandroidextensions

import android.os.Build
import android.text.Html
import android.util.Patterns

val String.Companion.EMPTY: String
    get() = ""


val String.Companion.WHITESPACE: String
    get() = " "

fun String.clearHtml(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        Html.fromHtml(this).toString()
    }
}

fun String.isWebUrl() = Patterns.WEB_URL.matcher(this).matches()
