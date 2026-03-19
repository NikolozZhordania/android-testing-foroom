package com.example.foroom.Steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Data.Constants.VIEW_VISIBILITY_TIMEOUT
import com.example.foroom.Helper.KeyboardHelper
import com.example.foroom.Helper.getText
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.typeText
import com.example.foroom.Helper.waitUntilVisible
import com.example.foroom.Page.LoginPageMatchers
import org.junit.Assert.assertTrue

class LoginSteps {

    fun typeUsername(username: String): LoginSteps {
        LoginPageMatchers.usernameInput.typeText(username)
        return this
    }

    fun typePassword(password: String): LoginSteps {
        LoginPageMatchers.passwordInput.typeText(password)
        return this
    }

    fun closeKeyboard(): LoginSteps {
        KeyboardHelper.closeKeyboard()
        return this
    }

    fun clickLogin(): LoginSteps {
        LoginPageMatchers.loginButton.tap()
        return this
    }

    fun checkPasswordErrorMessageVisibility(): LoginSteps{
        Thread.sleep(2000)
        onView(LoginPageMatchers.passwordErrorMessage)
            .waitUntilVisible(VIEW_VISIBILITY_TIMEOUT)
        return this
    }

    fun checkUsernameErrorMessageVisibility(): LoginSteps{
        Thread.sleep(2000)
        onView(LoginPageMatchers.usernameErrorMessage)
            .waitUntilVisible(VIEW_VISIBILITY_TIMEOUT)
        return this
    }
    fun checkUsernameError(vararg expected: String): LoginSteps {
        val actual = LoginPageMatchers.usernameErrorMessage.getText()
        assertTrue(expected.any { it == actual })
        return this
    }

    fun checkPasswordError(vararg expected: String): LoginSteps {
        val actual = LoginPageMatchers.passwordErrorMessage.getText()
        assertTrue(expected.any { it == actual })
        return this
    }

    fun clickSignUpButton(): LoginSteps{
        LoginPageMatchers.signUpButton.tap()
        return this
    }
}