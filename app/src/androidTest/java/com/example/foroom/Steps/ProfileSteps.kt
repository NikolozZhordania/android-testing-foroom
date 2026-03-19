package com.example.foroom.Steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Data.Constants.VIEW_VISIBILITY_TIMEOUT
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.typeText
import com.example.foroom.Helper.waitUntilVisible
import com.example.foroom.Page.ProfilePageMatchers
import com.example.foroom.Helper.getText
import org.junit.Assert.assertTrue


class ProfileSteps {
    fun signOut(): ProfileSteps{
        ProfilePageMatchers.signOutButton.tap()
        return this
    }

    fun signOutButtonVisibilityValidation(): ProfileSteps{
        onView(ProfilePageMatchers.signOutButton)
            .waitUntilVisible(VIEW_VISIBILITY_TIMEOUT)
        return this
    }

    fun clickChangePasswordButton(): ProfileSteps{
        ProfilePageMatchers.changePasswordButton.tap()
        return this
    }

    fun enterNewPassword(newPassword: String): ProfileSteps{
        Thread.sleep(2000)
        ProfilePageMatchers.changePasswordInput.typeText(newPassword)
        return this
    }

    fun enterNewRepeatPassword(newRepeatPassword: String): ProfileSteps{
        ProfilePageMatchers.changePasswordRepeatInput.typeText(newRepeatPassword)
        return this
    }

    fun clickConfirmButton(): ProfileSteps{
        ProfilePageMatchers.confirmButton.tap()
        return this
    }

    fun validateUsername(username: String): ProfileSteps {
        val text = ProfilePageMatchers.userNameDisplay.getText()
        assertTrue(text == username)
        return this
    }

    fun clickChangeLanguageButton(): ProfileSteps{
        ProfilePageMatchers.changeLanguageButton.tap()
        return this
    }

    fun changeLanguageToGeo(): ProfileSteps{
        ProfilePageMatchers.languageButtonGeo.tap()
        return this
    }

    fun changeLanguageToEng(): ProfileSteps{
        ProfilePageMatchers.languageButtonEng.tap()
        return this
    }

    fun validateLanguageChange(geoTextField: String, engTextField: String): ProfileSteps{
        assertTrue(ProfilePageMatchers.languageButtonGeo.getText() == geoTextField)
        assertTrue(ProfilePageMatchers.languageButtonEng.getText() == engTextField)
        return this
    }

}