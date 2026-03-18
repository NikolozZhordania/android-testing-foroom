package com.example.foroom.Page

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

object ChatCreationPageMatchers {

    val chatHeaderView: Matcher<View> by lazy { withId(R.id.chatHeaderView) }

    val chatNameInput: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.chatNameInput))) }

    val createChatButton: Matcher<View> by lazy { withId(R.id.createChatButton) }

    val chatName: Matcher<View> by lazy { allOf(withId(
        com.example.design_system.R.id.chatNameTextView),
        isDescendantOfA(chatHeaderView)) }

    val usernameDisplayed: Matcher<View> by lazy { allOf(withId(
        com.example.design_system.R.id.userNameTextView),
        isDescendantOfA(chatHeaderView)) }

}