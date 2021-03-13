package services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumDigitsValidationServiceTest{

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expected result`(password: String, expectedResult: Boolean){
        val minimumDigitsValidationService = MinimumDigitsValidationService()
        val result = minimumDigitsValidationService.isValid(password)

        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of("password1", true),
        Arguments.of( "", false))
    }
}