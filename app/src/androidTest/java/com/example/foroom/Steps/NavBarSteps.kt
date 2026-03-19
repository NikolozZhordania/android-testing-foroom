package com.example.foroom.Steps

import androidx.test.espresso.Espresso.onView
import com.example.foroom.Data.Constants.VIEW_VISIBILITY_TIMEOUT
import com.example.foroom.Helper.tap
import com.example.foroom.Helper.waitUntilVisible
import com.example.foroom.Page.NavigationBarMatchers

class NavBarSteps {
    fun profilePageNavigation(): NavBarSteps{
        NavigationBarMatchers.profileButton.tap()
        return this
    }

    fun profileButtonVisibilityValidation(): NavBarSteps{
        Thread.sleep(2000)
        onView(NavigationBarMatchers.profileButton)
            .waitUntilVisible(VIEW_VISIBILITY_TIMEOUT)
        return this
    }

    fun clickCreateNewChatButton(): NavBarSteps{
        NavigationBarMatchers.createChatButton.tap()
        return this
    }

}