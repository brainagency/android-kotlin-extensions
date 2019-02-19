package com.wearebrain.kotlinandroidextensions

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


inline fun EditText.onGoClicked(crossinline block: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        return@setOnEditorActionListener if (actionId == EditorInfo.IME_ACTION_GO) {
            block.invoke()
            true
        } else {
            false
        }
    }
}

inline fun EditText.onSearchClicked(crossinline block: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        return@setOnEditorActionListener if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            block.invoke()
            true
        } else {
            false
        }
    }
}

inline fun EditText.onSendClicked(crossinline block: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        return@setOnEditorActionListener if (actionId == EditorInfo.IME_ACTION_SEND) {
            block.invoke()
            true
        } else {
            false
        }
    }
}

inline fun EditText.onNextClicked(crossinline block: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        return@setOnEditorActionListener if (actionId == EditorInfo.IME_ACTION_NEXT) {
            block.invoke()
            true
        } else {
            false
        }
    }
}

inline fun EditText.onDoneClicked(crossinline block: () -> Unit) {
    setOnEditorActionListener { _, actionId, _ ->
        return@setOnEditorActionListener if (actionId == EditorInfo.IME_ACTION_DONE) {
            block.invoke()
            true
        } else {
            false
        }
    }
}

inline fun EditText.onFocused(crossinline block: () -> Unit) {
    setOnFocusChangeListener { _, hasFocus ->
        if (hasFocus) block.invoke()
    }
}

inline fun EditText.onUnFocused(crossinline block: () -> Unit) {
    setOnFocusChangeListener { _, hasFocus ->
        if (!hasFocus) block.invoke()
    }
}

inline fun EditText.afterTextChanged(crossinline block: (String?) -> Unit): TextWatcher {
    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            s?.apply {
                block.invoke(this.toString())
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Not used
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Not used
        }
    }

    addTextChangedListener(textWatcher)

    return textWatcher
}

inline fun EditText.afterTextChangedDelayed(
    delayMillis: Long = 500,
    crossinline block: (String?) -> Unit
): TextWatcher {
    val textWatcher = object : TextWatcher {

        private val handler = Handler(Looper.getMainLooper())
        private var runnable: Runnable = Runnable { }

        override fun afterTextChanged(s: Editable?) {
            runnable = Runnable {
                s?.apply {
                    block.invoke(this.toString())
                }
            }

            handler.postDelayed(runnable, delayMillis)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Not used
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            handler.removeCallbacks(runnable)
        }
    }

    addTextChangedListener(textWatcher)

    return textWatcher
}

inline fun EditText.beforeTextChanged(crossinline block: (String?) -> Unit): TextWatcher {
    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            // Not used
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            s?.apply {
                block.invoke(this.toString())
            }
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Not used
        }
    }

    addTextChangedListener(textWatcher)

    return textWatcher
}

inline fun EditText.onTextChanged(crossinline block: (String?) -> Unit): TextWatcher {
    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            // Not used
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Not used
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            s?.apply {
                block.invoke(this.toString())
            }
        }
    }

    addTextChangedListener(textWatcher)

    return textWatcher
}

fun EditText.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun EditText.showKeyboardDelayed(delayMillis: Long) {
    Handler().postDelayed({ showKeyboard() }, delayMillis)
}

fun EditText.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun EditText.hideKeyboardDelayed(delayMillis: Long) {
    Handler().postDelayed({ hideKeyboard() }, delayMillis)
}

val EditText.textStr: String
    get() = text.toString()

