package com.wearebrain.ake.view

import android.widget.CompoundButton

/**
 * Sets CompoundButton.OnCheckedChangeListener and calls specified function [block]
 * if this button state changed to checked
 *
 * @see CompoundButton.setOnCheckedChangeListener
 * @see CompoundButton.OnCheckedChangeListener
 */
inline fun CompoundButton.onChecked(crossinline block: () -> Unit) {
    setOnCheckedChangeListener { _, isChecked ->
        if (isChecked) block.invoke()
    }
}

/**
 * Sets CompoundButton.OnCheckedChangeListener and calls specified function [block]
 * if this button state changed to unchecked
 *
 * @see CompoundButton.setOnCheckedChangeListener
 * @see CompoundButton.OnCheckedChangeListener
 */
inline fun CompoundButton.onUnChecked(crossinline block: () -> Unit) {
    setOnCheckedChangeListener { _, isChecked ->
        if (!isChecked) block.invoke()
    }
}