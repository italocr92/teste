package com.spring.teste.processor

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertTrue

class PasswordValidatorProcessorTest {


    private lateinit var passwordValidatorProcessor: PasswordValidatorProcessor

    @BeforeEach
    fun `setUp`(){
        passwordValidatorProcessor = PasswordValidatorProcessor()
    }


    @Test
    fun `should return false when password is empty`(){

        val result = passwordValidatorProcessor.validate("")

        assertFalse(result)
    }

    @Test
    fun `should return false when password is aa`(){

        val result = passwordValidatorProcessor.validate("aa")

        assertFalse(result)
    }

    @Test
    fun `should return false when password is ab`(){

        val result = passwordValidatorProcessor.validate("ab")

        assertFalse(result)
    }

    @Test
    fun `should return false when password is smaller then 9`(){

        val result = passwordValidatorProcessor.validate("AAAbbbCc")

        assertFalse(result)
    }

    @Test
    fun `should return false when password has repeat lowercase chars`(){

        val result = passwordValidatorProcessor.validate("AbTp9!foo")

        assertFalse(result)
    }

    @Test
    fun `should return false when password has repeat uppercase chars`(){

        val result = passwordValidatorProcessor.validate("AbTp9!foA")

        assertFalse(result)
    }

    @Test
    fun `should return false when password not has special char`(){

        val result = passwordValidatorProcessor.validate("AbTp9 fok")

        assertFalse(result)
    }

    @Test
    fun `should return true when password is complete`(){

        val result = passwordValidatorProcessor.validate("AbTp9!fok")

        assertTrue(result)
    }

}