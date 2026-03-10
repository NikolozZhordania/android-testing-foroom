package com.example.foroom.Steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Data.Constants.VIEW_VISIBILITY_TIMEOUT
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.waitUntilVisible
import com.example.foroom.Page.ProfilePageMatchers

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
}