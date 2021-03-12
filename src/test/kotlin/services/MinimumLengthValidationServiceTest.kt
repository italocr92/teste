package services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumLengthValidationServiceTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expected result`(minimumLength: Long, password: String, expectedResult: Boolean){
        val minimumLengthValidationService = MinimumLengthValidationService(minimumLength)
        val result = minimumLengthValidationService.isValid(password)

        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of(5, "passw", true),
        Arguments.of(6, "password", true),
        Arguments.of(5, "pass", false))
    }
}