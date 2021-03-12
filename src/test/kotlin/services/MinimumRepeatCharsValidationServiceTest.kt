package services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumRepeatCharsValidationServiceTest{

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expected result`(password: String, expectedResult: Boolean){
        val minimumRepeatCharsValidationService = MinimumRepeatCharsValidationService()
        val result = minimumRepeatCharsValidationService.isValid(password)

        assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of("pas", true),
            Arguments.of("pass", false))
    }
}