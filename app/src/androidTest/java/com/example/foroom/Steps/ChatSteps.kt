package com.example.foroom.Steps

import androidx.test.espresso.Espresso.pressBack
import com.example.foroom.Helper.KeyboardHelper
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.typeText

import com.example.foroom.Page.ChatPageMatchers
import org.junit.Assert.assertTrue

class ChatSteps {

    fun navigateToMainPage(): ChatSteps{
        pressBack()
        return this
    }

    fun validateUsername(username: String): ChatSteps{
        assertTrue(ChatPageMatchers.userName.getText() == username)
        return this
    }

    fun validateChatName(chatName: String): ChatSteps{
        assertTrue(ChatPageMatchers.chatName.getText() == chatName)
        return this
    }

    fun messageInput(message: String): ChatSteps{
        ChatPageMatchers.inputText.typeText(message)
        return this
    }

    fun pressSendButton(): ChatSteps{
        ChatPageMatchers.sendMessageButton.tap()
        return this
    }

    fun validateSentMessage(message: String): ChatSteps {
        assertTrue(ChatPageMatchers.sentMessage.getText() == message)
        return this
    }

    fun closeKeyboard(): ChatSteps {
        KeyboardHelper.closeKeyboard()
        return this
    }

}