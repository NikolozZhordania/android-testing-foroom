package com.example.foroom.Tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.foroom.Base.BaseTest
import com.example.foroom.Data.Constants.LANGUAGE_NAME_ENG_EN
import com.example.foroom.Data.Constants.LANGUAGE_NAME_ENG_GE
import com.example.foroom.Data.Constants.LANGUAGE_NAME_GEO_EN
import com.example.foroom.Data.Constants.LANGUAGE_NAME_GEO_GE
import com.example.foroom.Data.Constants.MESSAGE
import com.example.foroom.Data.Constants.VALID_USERNAME
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserProfileTests : BaseTest() {
    @get:Rule
    val testName = TestName()

    @Before
    override fun beforeMethod() {
        if (testName.methodName == "TC1_userPasswordUpdate") return
        super.beforeMethod()
    }

    @Test
    fun TC1_userPasswordUpdate(){
        loginSteps
            .clickSignUpButton()
        registrationSteps
            .checkUsernameInputVisibility()
            .userNameInput(username)
            .passwordInput(password)
            .repeatPasswordInput(password)
            .closeKeyboard()
            .clickSignUpButton()
        navBarSteps
            .profileButtonVisibilityValidation()
            .profilePageNavigation()
        profileSteps
            .clickChangePasswordButton()
            .enterNewPassword(newPassword)
            .enterNewRepeatPassword(newPassword)
            .clickConfirmButton()
        loginSteps
            .waitForLoginScreen()
            .typeUsername(username, index = 0)
            .typePassword(newPassword, index = 1)
            .closeKeyboard()
            .clickLogin()
        navBarSteps
            .profileButtonVisibilityValidation()
            .profilePageNavigation()
        profileSteps
            .validateUsername(username)
            .signOut()
    }

    @Test
    fun TC2_changeLanguageValidation(){
        navBarSteps
            .profileButtonVisibilityValidation()
            .profilePageNavigation()
        profileSteps
            .clickChangeLanguageButton()
            .changeLanguageToGeo()
            .clickChangeLanguageButton()
            .validateLanguageChange(
                LANGUAGE_NAME_GEO_GE,
                LANGUAGE_NAME_ENG_GE)
            .changeLanguageToEng()
            .clickChangeLanguageButton()
            .validateLanguageChange(
                LANGUAGE_NAME_GEO_EN,
                LANGUAGE_NAME_ENG_EN)
            .changeLanguageToEng()
            .signOut()
    }

    @Test
    fun TC3_createChat(){
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
            .searchInput(randomChatName)
            .closeKeyboard()
            .validateChatName(randomChatName)
            .validateChatAuthorName(VALID_USERNAME)
        navBarSteps
            .profileButtonVisibilityValidation()
            .profilePageNavigation()
        profileSteps
            .signOut()
    }

}