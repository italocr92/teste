package com.spring.teste.services

import org.springframework.stereotype.Service

@Service
class MinimumUpperCaseValidationService : PasswordValidatorInterface {

    override fun isValid(password: String): Boolean = password.count { it -> it.isUpperCase() } >= 1
}