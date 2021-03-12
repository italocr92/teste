package services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MinimumDigitsValidationService @Autowired constructor(
    private val minimumDigits: Long
): PasswordValidatorInterface {

    override fun isValid(password: String) = password.count { it -> it.isDigit() } >= minimumDigits;
}