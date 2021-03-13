package processor

import com.spring.teste.processor.PasswordValidatorProcessor
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import com.spring.teste.services.PasswordValidatorInterface
import kotlin.test.Test
import kotlin.test.assertTrue

class PasswordValidatorProcessorTest {

    private val firstPasswordValidatorService: PasswordValidatorInterface = mockk()
    private val secondPasswordValidatorService: PasswordValidatorInterface = mockk()

    private val passwordValidatorInterface = listOf(firstPasswordValidatorService, secondPasswordValidatorService)

    private lateinit var passwordValidatorProcessor: PasswordValidatorProcessor

    @BeforeEach
    fun `setUp`(){
        passwordValidatorProcessor = PasswordValidatorProcessor(passwordValidatorInterface)
    }


    @Test
    fun `should return true when password valid in all services`(){
        every { firstPasswordValidatorService.isValid(any()) } returns true
        every { secondPasswordValidatorService.isValid(any()) } returns true

        val result = passwordValidatorProcessor.validate("password")

        assertTrue(result)
        verify(exactly = 1) { firstPasswordValidatorService.isValid(any()) }
        verify(exactly = 1) { secondPasswordValidatorService.isValid(any()) }
    }

    @Test
    fun `should return false and stop validating when password invalid in at least one service`(){
        every { firstPasswordValidatorService.isValid(any()) } returns false
        every { secondPasswordValidatorService.isValid(any()) } returns true

        val result = passwordValidatorProcessor.validate("password")

        assertFalse(result)
        verify(exactly = 1) { firstPasswordValidatorService.isValid(any()) }
        verify(exactly = 0) { secondPasswordValidatorService.isValid(any()) }
    }
}