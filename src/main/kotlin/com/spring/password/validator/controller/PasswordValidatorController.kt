package com.spring.password.validator.controller

import com.spring.password.validator.processor.PasswordValidatorProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["api/password"])
class PasswordValidatorController @Autowired constructor(private val service: PasswordValidatorProcessor){

    @GetMapping(value = ["validatePassword"])
    fun getValidatePassword(@RequestParam("password") password: String): ResponseEntity<Boolean> {
        return try {
            val isValid = service.validate(password)
            ResponseEntity(isValid, if (!isValid) HttpStatus.BAD_REQUEST else HttpStatus.OK)
        } catch (e: Exception){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }
}