package com.example.foroom.Helper

import com.github.javafaker.Faker

object FakerHelper {
    private val faker = Faker()

    fun generateUsername(): String {
        return "TEST_${faker.name().username().replace(
            ".", 
            "_").uppercase()}_${faker.number().digits(4)}"
    }

    fun generatePassword(): String {
        return "Test${faker.internet().password(
            6, 
            10, 
            true, 
            false)}1!"
    }
}