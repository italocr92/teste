package services

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class MinimumSpecialCharsValidationServiceTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun `should return expected result`(minimumSpecialChars: Long, specialChars: String , password: String, expectedResult: Boolean){
      val minimumSpecialCharsValidationService = MinimumSpecialCharsValidationService()
      val result = minimumSpecialCharsValidationService.isValid(password)

      assertEquals(expectedResult, result)
    }

    companion object{
        @JvmStatic
        fun arguments() = listOf(Arguments.of(1, "!@#$%^&*()_+", "password@", true),
        Arguments.of(1, "!@#$%^&*()_+", "password", false))
    }
}