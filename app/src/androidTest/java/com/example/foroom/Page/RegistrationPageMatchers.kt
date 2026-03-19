package com.example.foroom.Page

import android.view.View
import android.widget.EditText
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.endsWith
import org.hamcrest.core.AllOf.allOf

object RegistrationPageMatchers {
    private val RegistrationPageContainer: Matcher<View> = isDescendantOfA(
        withClassName(
            endsWith("ContentLoaderView")))
    val usernameInput: Matcher<View> by lazy {
        allOf(
            isDescendantOfA(withId(R.id.userNameInput)),
            isAssignableFrom(EditText::class.java),
            RegistrationPageContainer
        )
    }

    val passwordInput: Matcher<View> by lazy {
        allOf(
            isDescendantOfA(withId(R.id.passwordInput)),
            isAssignableFrom(EditText::class.java),
            RegistrationPageContainer
        )
    }

    val repeatPasswordInput: Matcher<View> by lazy {
        allOf(
            isDescendantOfA(withId(R.id.repeatPasswordInput)),
            isAssignableFrom(EditText::class.java),
            RegistrationPageContainer
        )
    }

    val signUpButton: Matcher<View> by lazy {
        allOf(
            withId(R.id.signUpButton),
            anyOf(
                withText("Sign Up"),
                withText("რეგისტრაცია")
            ),
            RegistrationPageContainer
        )
    }
}