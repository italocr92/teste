package services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MinimumSpecialCharsValidationService @Autowired constructor(
    private val minimumSpecialChars : Long , private val specialChars : CharArray  ):
PasswordValidatorInterface{

    override fun isValid(password: String): Boolean = password.count { it -> specialChars.contains(it)  } >= minimumSpecialChars
}