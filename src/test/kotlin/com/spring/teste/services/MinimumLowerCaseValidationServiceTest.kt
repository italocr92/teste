package com.spring.teste.services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumLowerCaseValidationServiceTest{

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expected result`(password: String, expectedResult: Boolean){
        val minimumLowerCaseValidationService = MinimumLowerCaseValidationService()
        val result = minimumLowerCaseValidationService.isValid(password)

        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of("Password", true),
            Arguments.of("PASSWORD", false))
    }
}