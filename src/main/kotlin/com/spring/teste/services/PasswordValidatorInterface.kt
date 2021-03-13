package com.spring.teste.services

interface PasswordValidatorInterface {

    fun isValid(password: String): Boolean
}