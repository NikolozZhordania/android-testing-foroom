package com.example.foroom.Base

import kotlin.jvm.JvmStatic
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.foroom.Helper.FakerHelper
import com.example.foroom.Steps.LoginSteps
import com.example.foroom.Steps.NavBarSteps
import com.example.foroom.Steps.ProfileSteps
import com.example.foroom.Steps.RegistrationSteps
import com.example.foroom.presentation.ui.activity.ForoomActivity

import org.junit.BeforeClass
import org.junit.Rule

open class BaseTest {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<ForoomActivity>()

    protected val loginSteps = LoginSteps()
    protected val navBarSteps = NavBarSteps()
    protected val profileSteps = ProfileSteps()
    protected val registrationSteps = RegistrationSteps()

    companion object {
        @JvmStatic
        protected lateinit var username: String
        @JvmStatic
        protected lateinit var password: String

        @JvmStatic
        @BeforeClass
        fun globalSetup() {
            username = FakerHelper.generateUsername()
            password = FakerHelper.generatePassword()
        }
    }
}