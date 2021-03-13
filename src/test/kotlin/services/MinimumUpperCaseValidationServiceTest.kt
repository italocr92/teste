package services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumUpperCaseValidationServiceTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expcted result`(minimumUpperCase: Long, password: String, expectedResult: Boolean){
        val minimumUpperCaseValidationService = MinimumUpperCaseValidationService()
        val result = minimumUpperCaseValidationService.isValid(password)

        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of("Password", true),
        Arguments.of("password", false))
    }
}