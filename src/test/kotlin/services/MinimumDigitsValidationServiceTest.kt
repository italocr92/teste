package services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumDigitsValidationServiceTest{

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expected result`(minimumDigits: Long, password: String, expectedResult: Boolean){
        val minimumDigitsValidationService = MinimumDigitsValidationService(minimumDigits)
        val result = minimumDigitsValidationService.isValid(password)

        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of(1, "password1", true),
        Arguments.of(2, "password2", false))
    }
}