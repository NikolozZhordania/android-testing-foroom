package com.example.foroom.Page

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.design_system.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

object ChatPageMatchers {

    val chatName: Matcher<View> by lazy { withId(R.id.chatNameTextView) }

    val userName: Matcher<View> by lazy { withId(R.id.userNameTextView) }

    val sendMessageButton: Matcher<View> by lazy { withId(R.id.sendMessageButton) }

    val inputText: Matcher<View> by lazy { allOf(
        withId(R.id.inputEditText),
        isDescendantOfA(withId(com.alternator.foroom.R.id.messageInput))) }

    val sentMessage: Matcher<View> by lazy { withId(R.id.messageTextView) }

}