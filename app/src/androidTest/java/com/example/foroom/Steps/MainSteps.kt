package com.example.foroom.Steps

import com.example.foroom.Helper.KeyboardHelper
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.typeText
import com.example.foroom.Page.MainPageMatchers
import org.junit.Assert.assertTrue

class MainSteps {
    fun searchInput(chatName: String): MainSteps{
        MainPageMatchers.searchChatInput.typeText(chatName)
        return this
    }

    fun closeKeyboard(): MainSteps {
        KeyboardHelper.closeKeyboard()
        return this
    }


    fun validateChatAuthorName(authorName: String): MainSteps{
        assertTrue(MainPageMatchers.authorName.getText() == authorName)
        return this
    }

    fun validateChatName(chatName: String): MainSteps{
        assertTrue(MainPageMatchers.chatTitle.getText() == chatName)
        return this
    }

}