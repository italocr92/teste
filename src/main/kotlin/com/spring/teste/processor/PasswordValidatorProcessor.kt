package com.spring.teste.processor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.spring.teste.services.PasswordValidatorInterface
import java.util.logging.Logger

@Service
class PasswordValidatorProcessor @Autowired constructor(
    private val passwordValidatorInterface: List<PasswordValidatorInterface>):
    PasswordValidatorProcessorInterface {

    val logger: Logger = Logger.getLogger(javaClass.toString())

    override fun validate(password: String) =
            passwordValidatorInterface.all{it -> it.isValid(password)}
}