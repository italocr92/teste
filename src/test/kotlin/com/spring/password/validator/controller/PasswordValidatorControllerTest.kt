package com.spring.password.validator.controller

import com.spring.password.validator.controller.PasswordValidatorController
import com.spring.password.validator.processor.PasswordValidatorProcessor
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.springframework.http.HttpStatus
import java.lang.RuntimeException
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
    fun `should return internal server error and false when valid password`(){
        every { passwordValidatorProcessor.validate(any()) } returns false

        val response = passwordController.getValidatePassword("invalid_password")

        assertNotNull(response)
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.statusCode)
    }

    @Test
    fun `should catch exception when requeted`(){
        every { passwordValidatorProcessor.validate(any()) } throws RuntimeException()

        val response = passwordController.getValidatePassword("invalid_password")

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.statusCode)
    }

}