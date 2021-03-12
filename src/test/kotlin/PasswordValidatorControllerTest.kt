import controller.PasswordValidatorController
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import processor.PasswordValidatorProcessor
import kotlin.test.*

class PasswordValidatorControllerTest {

    private val passwordValidatorProcessor: PasswordValidatorProcessor = mockk()
    private lateinit var passwordController: PasswordValidatorController

    @BeforeEach
    fun `setUp`(){
        passwordController = PasswordValidatorController(passwordValidatorProcessor)
    }

    @Test
    fun `should return ok and true when valid password`(){
        every { passwordValidatorProcessor.validate(any()) } returns true

        val response = passwordController.getValidatePassword("password")

        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun `should return bad request and false when valid password`(){
        every { passwordValidatorProcessor.validate(any()) } returns false

        val response = passwordController.getValidatePassword("invalid_password")

        assertNotNull(response)
        assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
    }

}