package com.spring.teste.services

import org.springframework.stereotype.Service

@Service
class MinimumLowerCaseValidationService : PasswordValidatorInterface {

    override fun isValid(password: String): Boolean = password.count { it -> it.isLowerCase() } >= 1;
}