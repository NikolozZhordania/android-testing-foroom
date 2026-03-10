package com.example.foroom.Page

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matcher

object ProfilePageMatchers {
    val signOutButton: Matcher<View> by lazy { withId(R.id.signOutItem) }
}