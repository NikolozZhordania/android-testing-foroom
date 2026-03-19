package com.example.foroom.Helper

import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.Swiper

enum class SwipeDirection { UP, DOWN, LEFT, RIGHT }

class ScrollHelper {

    fun customSwipe(
        direction: SwipeDirection = SwipeDirection.UP,
        speed: Swiper = Swipe.SLOW,
        startRatio: Float = 0.8f,
        endRatio: Float = 0.2f
    ): ViewAction {
        val (start, end) = when (direction) {
            SwipeDirection.UP -> Pair(
                GeneralLocation.translate(GeneralLocation.BOTTOM_CENTER, 0f, -(1f - startRatio)),
                GeneralLocation.translate(GeneralLocation.TOP_CENTER, 0f, endRatio)
            )
            SwipeDirection.DOWN -> Pair(
                GeneralLocation.translate(GeneralLocation.TOP_CENTER, 0f, endRatio),
                GeneralLocation.translate(GeneralLocation.BOTTOM_CENTER, 0f, -(1f - startRatio))
            )
            SwipeDirection.LEFT -> Pair(
                GeneralLocation.translate(GeneralLocation.CENTER_RIGHT, -(1f - startRatio), 0f),
                GeneralLocation.translate(GeneralLocation.CENTER_LEFT, endRatio, 0f)
            )
            SwipeDirection.RIGHT -> Pair(
                GeneralLocation.translate(GeneralLocation.CENTER_LEFT, endRatio, 0f),
                GeneralLocation.translate(GeneralLocation.CENTER_RIGHT, -(1f - startRatio), 0f)
            )
        }

        return GeneralSwipeAction(speed, start, end, Press.FINGER)
    }
}