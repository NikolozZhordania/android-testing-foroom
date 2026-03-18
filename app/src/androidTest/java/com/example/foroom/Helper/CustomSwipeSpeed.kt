package com.example.foroom.Helper

import android.os.SystemClock
import androidx.test.espresso.UiController
import androidx.test.espresso.action.MotionEvents
import androidx.test.espresso.action.Swiper

enum class CustomSwipeSpeed(private val px: Float) : Swiper {
    VERY_SLOW(200f),
    NORMAL(1000f),
    VERY_FAST(3000f);

    override fun sendSwipe(
        uiController: UiController,
        startCoordinates: FloatArray,
        endCoordinates: FloatArray,
        precision: FloatArray
    ): Swiper.Status {
        val steps = (px / 100).toInt().coerceAtLeast(2)
        val xStep = (endCoordinates[0] - startCoordinates[0]) / steps
        val yStep = (endCoordinates[1] - startCoordinates[1]) / steps

        val downEvent = MotionEvents.obtainDownEvent(startCoordinates, precision)

        try {
            uiController.injectMotionEvent(downEvent)

            for (i in 1 until steps) {
                val moveCoords = floatArrayOf(
                    startCoordinates[0] + xStep * i,
                    startCoordinates[1] + yStep * i
                )
                val moveEvent = MotionEvents.obtainMovement(
                    downEvent,
                    SystemClock.uptimeMillis(),
                    moveCoords
                )
                uiController.injectMotionEvent(moveEvent)
                moveEvent.recycle()
                uiController.loopMainThreadForAtLeast(10)
            }

            val upEvent = MotionEvents.obtainUpEvent(
                downEvent,
                SystemClock.uptimeMillis(),
                endCoordinates
            )
            uiController.injectMotionEvent(upEvent)
            upEvent.recycle()

        } finally {
            downEvent.recycle()
        }

        return Swiper.Status.SUCCESS
    }
}