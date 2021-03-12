package services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MinimumLengthValidationService @Autowired constructor(
    private val minimumLength: Long):
PasswordValidatorInterface{

    override fun isValid(password: String): Boolean = password.length >= minimumLength;
}