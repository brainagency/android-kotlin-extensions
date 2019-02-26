package com.wearebrain.ake.view

import android.view.View
import android.widget.EditText

/**
 * Change view's visibility to View.GONE
 *
 * @see View.GONE
 * @see View.setVisibility
 */
fun View.setGone() {
    visibility = View.GONE
}

/**
 * Check if view's visibility is View.GONE
 *
 * @see View.GONE
 * @see View.getVisibility
 */
fun View.isGone(): Boolean = visibility == View.GONE

/**
 * Change view's visibility to View.INVISIBLE
 *
 * @see View.INVISIBLE
 * @see View.setVisibility
 */
fun View.setInvisible() {
    visibility = View.INVISIBLE
}

/**
 * Check if view's visibility is View.INVISIBLE
 *
 * @see View.GONE
 * @see View.getVisibility
 */
fun View.isInvisible(): Boolean = visibility == View.INVISIBLE

/**
 * Change view's visibility to View.VISIBLE
 *
 * @see View.VISIBLE
 * @see View.setVisibility
 */
fun View.setVisible() {
    visibility = View.VISIBLE
}

/**
 * Check if view's visibility is View.VISIBLE
 *
 * @see View.GONE
 * @see View.getVisibility
 */
fun View.isVisible(): Boolean = visibility == View.VISIBLE

/**
 * Sets OnFocusChangeListener and calls specified function [block]
 * if this view become focused
 *
 * @see View.OnFocusChangeListener
 * @see View.setOnFocusChangeListener
 */
inline fun EditText.onFocused(crossinline block: () -> Unit) {
    setOnFocusChangeListener { _, hasFocus ->
        if (hasFocus) block.invoke()
    }
}

/**
 * Sets OnFocusChangeListener and calls specified function [block]
 * if this view become unfocused
 *
 * @see View.OnFocusChangeListener
 * @see View.setOnFocusChangeListener
 */
inline fun EditText.onUnFocused(crossinline block: () -> Unit) {
    setOnFocusChangeListener { _, hasFocus ->
        if (!hasFocus) block.invoke()
    }
}

/**
 * Sets OnClickListener and calls specified function [block] when view was clicked
 *
 * @see View.OnClickListener
 * @see View.setOnClickListener
 */
inline fun View.onClick(crossinline block: () -> Unit) {
    setOnClickListener { block.invoke() }
}

/**
 * Sets OnLongClickListener and calls specified function [block] when view was long clicked
 *
 * @see View.OnLongClickListener
 * @see View.setOnLongClickListener
 */
inline fun View.onLongClick(crossinline block: () -> Unit) {
    setOnLongClickListener {
        block.invoke()
        true
    }
}

/**
 * Set enabled state for this view
 *
 * @see View.setEnabled
 * @see View.isEnabled
 */
fun View.enable() {
    isEnabled = true
}

/**
 * Set disabled state for this view
 *
 * @see View.setEnabled
 * @see View.isEnabled
 */
fun View.disable() {
    isEnabled = false
}

