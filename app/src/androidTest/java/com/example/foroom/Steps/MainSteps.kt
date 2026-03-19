package com.example.foroom.Steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.foroom.Helper.KeyboardHelper
import com.example.foroom.Helper.ScrollHelper
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.typeText
import com.example.foroom.Page.MainPageMatchers
import org.hamcrest.Matchers.allOf
import org.junit.Assert.assertTrue
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import com.example.foroom.Helper.ChatHelper
import com.example.foroom.Helper.withIndex


class MainSteps {
    private val chatHelper = ChatHelper()

    fun searchInput(chatName: String): MainSteps {
        MainPageMatchers.searchChatInput.typeText(chatName)
        return this
    }

    fun closeKeyboard(): MainSteps {
        KeyboardHelper.closeKeyboard()
        return this
    }

    fun validateChatAuthorName(authorName: String): MainSteps {
        assertTrue(MainPageMatchers.authorName.getText() == authorName)
        return this
    }

    fun validateChatName(chatName: String): MainSteps {
        Thread.sleep(500)
        assertTrue(MainPageMatchers.chatTitle.getText() == chatName)
        return this
    }

    fun swipeToChatName(chatName: String): MainSteps {
        val maxSwipes = 20
        val scrollHelper = ScrollHelper()

        repeat(maxSwipes) {
            if (chatHelper.isChatVisible(chatName)) return this
            chatHelper.scrollChatList(scrollHelper)
        }

        throw AssertionError("Chat '$chatName' not found after $maxSwipes swipes")
    }

    fun clickChat(chatName: String, index: Int = 0): MainSteps {
        onView(allOf(MainPageMatchers.chatsRecyclerView, isDisplayed(), withIndex(index)))
            .perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(
                hasDescendant(MainPageMatchers.chatTitleWithText(chatName)),
                chatHelper.clickSendMessageButton()
            ))
        return this
    }
}