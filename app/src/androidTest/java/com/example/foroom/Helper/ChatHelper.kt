package com.example.foroom.Helper

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.alternator.foroom.R
import com.example.foroom.Page.MainPageMatchers
import org.hamcrest.Matchers.allOf

class ChatHelper {

    fun isChatVisible(chatName: String): Boolean {
        return try {
            onView(MainPageMatchers.chatsRecyclerViewWithChat(chatName))
                .check(matches(isDisplayed()))
            true
        } catch (e: NoMatchingViewException) {
            false
        } catch (e: AssertionError) {
            false
        }
    }

   fun scrollChatList(scrollHelper: ScrollHelper) {
        onView(allOf(MainPageMatchers.chatsRecyclerView, isDisplayed(), withIndex(0)))
            .perform(scrollHelper.customSwipe(direction = SwipeDirection.UP, speed = CustomSwipeSpeed.NORMAL))
    }

   fun clickSendMessageButton() = object : ViewAction {
        override fun getConstraints() = isDisplayed()
        override fun getDescription() = "click sendMessageButton in item"
        override fun perform(uiController: UiController, view: View) {
            view.findViewById<View>(R.id.sendMessageButton).performClick()
            uiController.loopMainThreadUntilIdle()
        }
    }

}