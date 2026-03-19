package com.example.foroom.Page

import android.view.View

import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf


object ProfilePageMatchers {

    private val ChangePasswordContainer: Matcher<View> = isDescendantOfA(
        withId(com.example.design_system.R.id.contentContainer)
    )
    val signOutButton: Matcher<View> by lazy { withId(R.id.signOutItem) }

    val changePasswordButton: Matcher<View> by lazy { withId(R.id.changePasswordItem) }

    val changeLanguageButton: Matcher<View> by lazy { withId(R.id.changeLanguageItem) }

    val changePasswordInput: Matcher<View> by lazy {
        allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.passwordInput)),
            ChangePasswordContainer
        )
    }

    val changePasswordRepeatInput: Matcher<View> by lazy {
        allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.repeatPasswordInput)),
            ChangePasswordContainer
        )
    }

    val confirmButton: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.actionButton),
        anyOf(
        withText("დადასტურება"),
        withText("Confirm"))) }

    val languageButtonGeo: Matcher<View> by lazy { allOf(
        withId(R.id.languageButtonGeo),
        anyOf(
            withText("ქართული"),
            withText("Georgian"))) }

    val languageButtonEng: Matcher<View> by lazy { allOf(
        withId(R.id.languageButtonEng),
        ChangePasswordContainer,
        anyOf(
            withText("ინგლისური"),
            withText("English"))) }

    val userNameDisplay: Matcher<View> by lazy { withId(R.id.userNameTextView) }
}