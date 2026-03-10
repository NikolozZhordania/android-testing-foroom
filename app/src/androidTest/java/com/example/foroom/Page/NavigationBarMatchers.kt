package com.example.foroom.Page

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf

object NavigationBarMatchers {
    val navBarContainer: Matcher<View> by lazy { withId(R.id.navBar) }

    val profileButton: Matcher<View> by lazy { allOf(
        isDescendantOfA(navBarContainer),
        withId(R.id.homeNavigationProfile)) }
}