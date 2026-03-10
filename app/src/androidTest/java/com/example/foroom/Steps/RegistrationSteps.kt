package com.example.foroom.Steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Data.Constants.VIEW_VISIBILITY_TIMEOUT
import com.example.foroom.Helper.KeyboardHelper
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.typeText
import com.example.foroom.Helper.waitUntilVisible
import com.example.foroom.Page.RegistrationPageMatchers

class RegistrationSteps {

    fun userNameInput(username: String): RegistrationSteps{
        RegistrationPageMatchers.usernameInput.typeText(username)
        return this
    }

    fun checkUsernameInputVisibility(): RegistrationSteps{
        Thread.sleep(2000)
        onView(RegistrationPageMatchers.usernameInput)
            .waitUntilVisible(VIEW_VISIBILITY_TIMEOUT)
        return this
    }

    fun passwordInput(password: String): RegistrationSteps{
        RegistrationPageMatchers.passwordInput.typeText(password)
        return this
    }

    fun repeatPasswordInput(password: String): RegistrationSteps{
        RegistrationPageMatchers.repeatPasswordInput.typeText(password)
        return this
    }

    fun closeKeyboard(): RegistrationSteps {
        KeyboardHelper.closeKeyboard()
        return this
    }

    fun clickSignUpButton(): RegistrationSteps{
        RegistrationPageMatchers.signUpButton.tap()
        return this
    }

}