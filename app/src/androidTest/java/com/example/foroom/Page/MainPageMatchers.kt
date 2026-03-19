package com.example.foroom.Page

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R

import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

object MainPageMatchers {

    val authorName: Matcher<View> by lazy { withId(com.example.design_system.R.id.authorNameTextView) }

    val chatTitle: Matcher<View>by lazy { withId(com.example.design_system.R.id.chatTitleTextView) }

    val searchChatInput: Matcher<View> by lazy { allOf(isDescendantOfA(
        withId(R.id.searchChatInput)),
        withId(com.example.design_system.R.id.inputEditText)) }

}