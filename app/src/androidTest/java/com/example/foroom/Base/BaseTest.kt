package com.example.foroom.Base

import kotlin.jvm.JvmStatic
import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.foroom.Data.Constants.VALID_PASSWORD
import com.example.foroom.Data.Constants.VALID_USERNAME
import com.example.foroom.Helper.FakerHelper
import com.example.foroom.Steps.ChatCreationSteps
import com.example.foroom.Steps.ChatSteps
import com.example.foroom.Steps.LoginSteps
import com.example.foroom.Steps.MainSteps
import com.example.foroom.Steps.NavBarSteps
import com.example.foroom.Steps.ProfileSteps
import com.example.foroom.Steps.RegistrationSteps
import com.example.foroom.presentation.ui.activity.ForoomActivity
import org.junit.Before

import org.junit.BeforeClass
import org.junit.Rule
import org.junit.rules.TestName

open class BaseTest {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<ForoomActivity>()

    protected val loginSteps = LoginSteps()
    protected val navBarSteps = NavBarSteps()
    protected val profileSteps = ProfileSteps()
    protected val registrationSteps = RegistrationSteps()
    protected val mainSteps = MainSteps()
    protected val chatCreationSteps = ChatCreationSteps()
    protected val chatSteps = ChatSteps()

    companion object {
        @JvmStatic
        protected lateinit var username: String
        @JvmStatic
        protected lateinit var password: String

        @JvmStatic
        protected lateinit var newPassword: String

        @JvmStatic
        protected lateinit var randomChatName: String

        @JvmStatic
        @BeforeClass
        fun globalSetup() {
            randomChatName = FakerHelper.generateRandomChatName()
            username = FakerHelper.generateUsername()
            password = FakerHelper.generatePassword()
            newPassword = FakerHelper.generatePassword() + "new"
        }
    }

    @Before
    open fun beforeMethod() {
        loginSteps
            .typeUsername(VALID_USERNAME)
            .typePassword(VALID_PASSWORD)
            .closeKeyboard()
            .clickLogin()
    }

}