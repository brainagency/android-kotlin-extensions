package com.wearebrain.ake.view

import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.wearebrain.ake.context.inputMethodService

/**
 * Returns string representation of text value of this edit text
 *
 * @see EditText.getText
 */
val EditText.textStr: String
    get() = text.toString()

/**
 * Returns string representation of text values of text view text
 *
 * @see EditText.getText
 */
val TextView.textStr: String
    get() = text.toString()


/**
 * Sets TextView.OnEditorActionListener and calls specified function [block]
 * if EditorInfo.IME_ACTION_GO was specified for this edit text
 *
 * @see EditText.setOnEditorActionListener
 * @see TextView.OnEditorActionListener
 */
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

/**
 * Sets TextView.OnEditorActionListener and calls specified function [block]
 * if EditorInfo.IME_ACTION_SEARCH was specified for this edit text
 *
 * @see EditText.setOnEditorActionListener
 * @see TextView.OnEditorActionListener
 */
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

/**
 * Sets TextView.OnEditorActionListener and calls specified function [block]
 * if EditorInfo.IME_ACTION_SEND was specified for this edit text
 *
 * @see EditText.setOnEditorActionListener
 * @see TextView.OnEditorActionListener
 */
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

/**
 * Sets TextView.OnEditorActionListener and calls specified function [block]
 * if EditorInfo.IME_ACTION_NEXT was specified for this edit text
 *
 * @see EditText.setOnEditorActionListener
 * @see TextView.OnEditorActionListener
 */
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

/**
 * Sets TextView.OnEditorActionListener and calls specified function [block]
 * if EditorInfo.IME_ACTION_DONE was specified for this edit text
 *
 * @see EditText.setOnEditorActionListener
 * @see TextView.OnEditorActionListener
 */
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

/**
 * Create and set new TextWatcher and calls specified function [block] after text was changed.
 *
 * @see TextWatcher.afterTextChanged
 * @see EditText.addTextChangedListener
 *
 * @return created TextWatcher to be able to remove it later
 */
inline fun EditText.afterTextChanged(crossinline block: (String) -> Unit): TextWatcher {
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

/**
 * Create and set new TextWatcher and calls specified function [block] after delay provided
 * text was changed.
 *
 * @param delayMillis - time before TextWatcher.afterTextChanged will be called
 *
 * @see TextWatcher.afterTextChanged
 * @see EditText.addTextChangedListener
 *
 * @return created TextWatcher to be able to remove it later
 */
inline fun EditText.afterTextChangedDelayed(
    delayMillis: Long = 500,
    crossinline block: (String) -> Unit
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

/**
 * Create and set new TextWatcher and calls specified function [block] before text will be changed.
 *
 * @see TextWatcher.beforeTextChanged
 * @see EditText.addTextChangedListener
 *
 * @return created TextWatcher to be able to remove it later
 */
inline fun EditText.beforeTextChanged(crossinline block: (String) -> Unit): TextWatcher {
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

/**
 * Create and set new TextWatcher and calls specified function [block] on text is changing.
 *
 * @see TextWatcher.onTextChanged
 * @see EditText.addTextChangedListener
 *
 * @return created TextWatcher to be able to remove it later
 */
inline fun EditText.onTextChanged(crossinline block: (String) -> Unit): TextWatcher {
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

/**
 * Shows keyboard for this edit text
 */
fun EditText.showKeyboard() {
    requestFocus()
    context.inputMethodService().showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * Shows keyboard for this edit text with delay
 *
 * @param delayMillis - delay in milliseconds before keyboard will be shown
 */
fun EditText.showKeyboardDelayed(delayMillis: Long) {
    Handler().postDelayed({
        requestFocus()
        showKeyboard()
    }, delayMillis)
}

/**
 * Hides keyboard for this edit text
 */
fun EditText.hideKeyboard() =
    context.inputMethodService().hideSoftInputFromWindow(
        windowToken,
        InputMethodManager.HIDE_NOT_ALWAYS
    )

/**
 * Hides keyboard for this edit text with delay
 *
 * @param delayMillis - delay in milliseconds before keyboard will be hided
 */
fun EditText.hideKeyboardDelayed(delayMillis: Long) =
    Handler().postDelayed({ hideKeyboard() }, delayMillis)