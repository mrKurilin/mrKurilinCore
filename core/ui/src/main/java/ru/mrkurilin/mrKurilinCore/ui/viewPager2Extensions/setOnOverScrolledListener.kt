package ru.mrkurilin.mrKurilinCore.ui.viewPager2Extensions

import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.setOnOverScrollListener(
    action: () -> Unit
) {

    this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        var previousState = ViewPager2.SCROLL_STATE_IDLE
        var currentPage = 0

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            currentPage = position
        }

        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
            if (
                state == ViewPager2.SCROLL_STATE_IDLE
                &&
                previousState == ViewPager2.SCROLL_STATE_DRAGGING
                &&
                currentPage > 0
            ) {
                action()
            } else {
                previousState = state
            }
        }
    })
}