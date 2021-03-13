package services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumLengthValidationServiceTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expected result`(password: String, expectedResult: Boolean){
        val minimumLengthValidationService = MinimumLengthValidationService()
        val result = minimumLengthValidationService.isValid(password)

        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of("passw", true),
        Arguments.of("password", true),
        Arguments.of("pass", false))
    }
}