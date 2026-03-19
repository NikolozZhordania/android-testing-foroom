package com.example.foroom.Tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.foroom.Base.BaseTest
import com.example.foroom.Data.Constants.AUTHOR_NAME
import com.example.foroom.Data.Constants.CHAT_MESSAGE
import com.example.foroom.Data.Constants.CHAT_MESSAGE_2
import com.example.foroom.Data.Constants.CHAT_NAME
import com.example.foroom.Data.Constants.GREETING
import com.example.foroom.Data.Constants.MESSAGE
import com.example.foroom.Data.Constants.REPLY
import com.example.foroom.Data.Constants.TARGET_CHAT
import com.example.foroom.Data.Constants.TARGET_CHAT_AUTHOR
import com.example.foroom.Data.Constants.VALID_PASSWORD_2
import com.example.foroom.Data.Constants.VALID_USERNAME
import com.example.foroom.Data.Constants.VALID_USERNAME_2
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ChatMessagingTests: BaseTest() {

    @Test
    fun TC1_sendMessageToExistingChat(){
        navBarSteps
            .profileButtonVisibilityValidation()
        mainSteps
            .swipeToChatName(CHAT_NAME)
            .clickChat(CHAT_NAME)
        chatSteps
            .validateChatName(CHAT_NAME)
            .validateUsername(AUTHOR_NAME)
            .messageInput(CHAT_MESSAGE)
            .closeKeyboard()
            .pressSendButton()
            .validateSentMessage(CHAT_MESSAGE)
            .navigateToMainPage()
        navBarSteps
            .profileButtonVisibilityValidation()
            .profilePageNavigation()
        profileSteps
            .signOut()
    }

    @Test
    fun TC2_sendMessageToCreatedChat(){
        navBarSteps
            .profileButtonVisibilityValidation()
            .clickCreateNewChatButton()
        chatCreationSteps
            .waitForChatHeaderVisibility()
            .validateUsername(VALID_USERNAME)
            .enterChatName(randomChatName)
            .closeKeyboard()
            .validateChatName(randomChatName)
            .clickCreateChatButton()
        chatSteps
            .validateUsername(VALID_USERNAME)
            .validateChatName(randomChatName)
            .messageInput(MESSAGE)
            .pressSendButton()
            .validateSentMessage(MESSAGE)
            .closeKeyboard()
            .navigateToMainPage()
        mainSteps
            .swipeToChatName(randomChatName)
            .clickChat(randomChatName)
        chatSteps
            .validateChatName(randomChatName)
            .messageInput(CHAT_MESSAGE_2)
            .closeKeyboard()
            .pressSendButton()
            .validateSentMessage(CHAT_MESSAGE_2)
            .navigateToMainPage()
        navBarSteps
            .profileButtonVisibilityValidation()
            .profilePageNavigation()
        profileSteps
            .signOut()
    }

    @Test
    fun TC3_exchangeMessagesBetweenUsers(){
        navBarSteps
            .profileButtonVisibilityValidation()
        mainSteps
            .swipeToChatName(TARGET_CHAT)
            .clickChat(TARGET_CHAT)
        chatSteps
            .validateChatName(TARGET_CHAT)
            .validateUsername(TARGET_CHAT_AUTHOR)
            .messageInput(GREETING)
            .closeKeyboard()
            .pressSendButton()
            .validateSentMessage(GREETING)
            .navigateToMainPage()
        navBarSteps
            .profileButtonVisibilityValidation()
            .profilePageNavigation()
        profileSteps
            .signOut()
        loginSteps
            .typeUsername(VALID_USERNAME_2)
            .typePassword(VALID_PASSWORD_2)
            .closeKeyboard()
            .clickLogin()
        mainSteps
            .swipeToChatName(TARGET_CHAT)
            .clickChat(TARGET_CHAT)
        chatSteps
            .validateChatName(TARGET_CHAT)
            .messageInput(REPLY)
            .closeKeyboard()
            .pressSendButton()
            .validateSentMessage(REPLY)
    }
}