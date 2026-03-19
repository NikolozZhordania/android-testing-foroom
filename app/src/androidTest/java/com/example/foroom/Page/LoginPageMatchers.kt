package com.example.foroom.Page

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.Helper.withIndex
import org.hamcrest.Matcher
import org.hamcrest.Matchers.anyOf
import org.hamcrest.core.AllOf.allOf

object LoginPageMatchers {
    fun usernameInput(index: Int = 0): Matcher<View> = withIndex(
        allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.userNameInput)),
            withText(""),
            isDisplayed()
        ),
        index = index
    )
    fun passwordInput(index: Int = 0): Matcher<View> = withIndex(
        allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.passwordInput)),
            withText(""),
            isDisplayed()
        ),
        index = index
    )

    val loginButton: Matcher<View> by lazy { allOf(
        withId(R.id.logInButton),
        anyOf(
            withText("Log In"),
            withText("ავტორიზაცია")
        )) }

    val signUpButton: Matcher<View> by lazy { allOf(
        withId(R.id.signUpButton),
        anyOf(
            withText("Sign Up"),
            withText("რეგისტრაცია")
        )) }

    val usernameErrorMessage: Matcher<View> by lazy { allOf(
        isDescendantOfA(withId(R.id.userNameInput)),
        withId(com.example.design_system.R.id.descriptionTextView)) }

    val passwordErrorMessage: Matcher<View> by lazy { allOf(
        isDescendantOfA(withId(R.id.passwordInput)),
        withId(com.example.design_system.R.id.descriptionTextView)) }
}