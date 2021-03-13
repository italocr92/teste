package services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MinimumLengthValidationService : PasswordValidatorInterface{

    override fun isValid(password: String): Boolean = password.length >= 9;
}