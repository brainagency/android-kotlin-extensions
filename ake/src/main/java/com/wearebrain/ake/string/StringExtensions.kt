package com.wearebrain.ake.string

import android.os.Build
import android.text.Html
import android.util.Patterns

/**
 * Returns empty string -> ""
 */
val String.Companion.EMPTY: String
    get() = ""

/**
 * Returns whitespace string -> " "
 */
val String.Companion.WHITESPACE: String
    get() = " "

/**
 * Clear all HTML tags from this string.
 *
 * @see Html.fromHtml(String source, int flags) for Build.VERSION >= Build.VERSION_CODES.N
 * @see Html.fromHtml(String source) otherwise
 */
fun String.clearHtmlTags(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        @Suppress("DEPRECATION")
        Html.fromHtml(this).toString()
    }
}

/**
 * Check if this string is valid web url
 *
 * @see Patterns.WEB_URL
 */
fun String.isValidWebUrl() = Patterns.WEB_URL.matcher(this).matches()

/**
 * Check if this string is valid web url
 *
 * @see Patterns.EMAIL_ADDRESS
 */
fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()

/**
 * Check if this string is valid web url
 *
 * @see Patterns.PHONE
 */
fun String.isValidPhoneNumber() = Patterns.PHONE.matcher(this).matches()

