package com.spring.teste.services

import org.springframework.stereotype.Service

@Service
class MinimumSpecialCharsValidationService : PasswordValidatorInterface {
    private var specialChars = arrayOf('!','@','#','$','%','^','&','*','(',')','_',"+")

    override fun isValid(password: String): Boolean = password.count { it -> specialChars.contains(it)  } >= 1
}