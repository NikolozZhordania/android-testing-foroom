package com.example.foroom.Steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Data.Constants.VIEW_VISIBILITY_TIMEOUT
import com.example.foroom.Helper.KeyboardHelper
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.typeText
import com.example.foroom.Helper.waitUntilVisible
import com.example.foroom.Page.ChatCreationPageMatchers
import org.junit.Assert.assertTrue

class ChatCreationSteps {

    fun waitForChatHeaderVisibility(): ChatCreationSteps{
        onView(ChatCreationPageMatchers.chatHeaderView)
            .waitUntilVisible(VIEW_VISIBILITY_TIMEOUT)
        return this
    }

    fun validateUsername(username: String): ChatCreationSteps{
        assertTrue(ChatCreationPageMatchers.usernameDisplayed.getText() == username)
        return this
    }

    fun validateChatName(chatName: String): ChatCreationSteps{
        assertTrue(ChatCreationPageMatchers.chatName.getText() == chatName)
        return this
    }

    fun enterChatName(chatName: String): ChatCreationSteps{
        ChatCreationPageMatchers.chatNameInput.typeText(chatName)
        return this
    }

    fun clickCreateChatButton(): ChatCreationSteps{
        ChatCreationPageMatchers.createChatButton.tap()
        return this
    }

    fun closeKeyboard(): ChatCreationSteps {
        KeyboardHelper.closeKeyboard()
        return this
    }

}