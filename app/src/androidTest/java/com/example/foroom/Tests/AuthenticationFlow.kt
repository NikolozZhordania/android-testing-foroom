package com.example.foroom.Tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.foroom.Base.BaseTest
import com.example.foroom.Data.Constants.ERROR_PASSWORD_INCORRECT_EN
import com.example.foroom.Data.Constants.ERROR_PASSWORD_INCORRECT_GE
import com.example.foroom.Data.Constants.ERROR_USER_NOT_FOUND_EN
import com.example.foroom.Data.Constants.ERROR_USER_NOT_FOUND_GE
import com.example.foroom.Data.Constants.INVALID_PASSWORD
import com.example.foroom.Data.Constants.INVALID_USERNAME
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AuthenticationFlow : BaseTest() {

    @Test
    fun TC1_userRegistrationFlow() {
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
    }

    @Test
    fun TC2_userLogOutFlow() {
        navBarSteps
            .profileButtonVisibilityValidation()
            .profilePageNavigation()
        profileSteps
            .signOutButtonVisibilityValidation()
            .signOut()
    }

    @Test
    fun TC3_validateInvalidPassword_onLoginPage() {
        loginSteps
            .typeUsername(username)
            .typePassword(INVALID_PASSWORD)
            .closeKeyboard()
            .clickLogin()
            .checkPasswordErrorMessageVisibility()
            .checkPasswordError(
                ERROR_PASSWORD_INCORRECT_EN,
                ERROR_PASSWORD_INCORRECT_GE )
    }

    @Test
    fun TC4_validateInvalidUserAndPassword_onLoginPage() {
        loginSteps
            .typeUsername(INVALID_USERNAME)
            .typePassword(password)
            .closeKeyboard()
            .clickLogin()
            .checkUsernameErrorMessageVisibility()
            .checkUsernameError(
                ERROR_USER_NOT_FOUND_EN,
                ERROR_USER_NOT_FOUND_GE)
    }
}