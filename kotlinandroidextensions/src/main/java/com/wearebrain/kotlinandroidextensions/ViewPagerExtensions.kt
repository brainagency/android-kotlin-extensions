package com.wearebrain.kotlinandroidextensions

import androidx.viewpager.widget.ViewPager

inline fun ViewPager.onPageSelected(crossinline block: (position: Int) -> Unit): ViewPager.OnPageChangeListener {
    val pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            block.invoke(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
            // Not used
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            // Not used
        }
    }

    addOnPageChangeListener(pageChangeListener)

    return pageChangeListener
}

inline fun ViewPager.onPageScrollStateChanged(crossinline block: (state: Int) -> Unit): ViewPager.OnPageChangeListener {
    val pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            // Not used
        }

        override fun onPageScrollStateChanged(state: Int) {
            block.invoke(state)
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            // Not used
        }
    }

    addOnPageChangeListener(pageChangeListener)

    return pageChangeListener
}

inline fun ViewPager.onPageScrolled(
    crossinline block: (
        position: Int,
        positionOffset: Float,
        positionOffsetPixels: Int
    ) -> Unit
): ViewPager.OnPageChangeListener {
    val pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            // Not used
        }

        override fun onPageScrollStateChanged(state: Int) {
            // Not used
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            block.invoke(position, positionOffset, positionOffsetPixels)
        }
    }

    addOnPageChangeListener(pageChangeListener)

    return pageChangeListener
}