package services

import org.springframework.stereotype.Service

@Service
class MinimumRepeatCharsValidationService : PasswordValidatorInterface {

    override fun isValid(password: String): Boolean = !password.toCharArray().groupBy { it -> it }.any{it -> it.value.count() > 1}
}