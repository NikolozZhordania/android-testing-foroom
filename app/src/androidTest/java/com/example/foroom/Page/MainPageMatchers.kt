package com.example.foroom.Page

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.Helper.withIndex

import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

object MainPageMatchers {

    val authorName: Matcher<View> by lazy { withId(com.example.design_system.R.id.authorNameTextView) }

    val chatTitle: Matcher<View> by lazy { withId(com.example.design_system.R.id.chatTitleTextView) }

    val searchChatInput: Matcher<View> by lazy {
        allOf(
            isDescendantOfA(withId(R.id.searchChatInput)),
            withId(com.example.design_system.R.id.inputEditText)
        )
    }

    val chatsRecyclerView: Matcher<View> by lazy { withId(R.id.chatsRecyclerView) }

    val sendMessageButton: Matcher<View> by lazy { withId(R.id.sendMessageButton) }

    fun chatTitleWithText(chatName: String): Matcher<View> =
        allOf(chatTitle, withText(chatName))

    fun chatsRecyclerViewWithChat(chatName: String, index: Int = 0): Matcher<View> =
        allOf(
            chatsRecyclerView,
            isDisplayed(),
            hasDescendant(chatTitleWithText(chatName)),
            withIndex(index)
        )
}