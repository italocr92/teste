package services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MinimumLowerCaseValidationService @Autowired constructor(
    private val minimumLowerCase: Long):
PasswordValidatorInterface{

    override fun isValid(password: String): Boolean = password.count { it -> it.isLowerCase() } >= minimumLowerCase;
}