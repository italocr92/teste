package services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumLowerCaseValidationServiceTest{

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expected result`(minimumLowerCase: Long, password: String, expectedResult: Boolean){
        val minimumLowerCaseValidationService = MinimumLowerCaseValidationService(minimumLowerCase)
        val result = minimumLowerCaseValidationService.isValid(password)

        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of(1, "Password", true),
            Arguments.of(2, "PASSWORD", false))
    }
}