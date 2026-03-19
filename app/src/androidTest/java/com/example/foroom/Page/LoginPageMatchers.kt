package com.example.foroom.Page

import android.view.View
import android.widget.EditText
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.anyOf
import org.hamcrest.core.AllOf.allOf
import kotlin.jvm.java

object LoginPageMatchers {
    val usernameInput: Matcher<View> by lazy {
        allOf(
            isDescendantOfA(withId(R.id.userNameInput)),
            isAssignableFrom(EditText::class.java)
        )
    }

    val passwordInput: Matcher<View> by lazy {
        allOf(
            isDescendantOfA(withId(R.id.passwordInput)),
            isAssignableFrom(EditText::class.java)
        )
    }

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