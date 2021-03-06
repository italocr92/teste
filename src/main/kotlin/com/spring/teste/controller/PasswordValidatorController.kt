package com.spring.teste.controller

import com.spring.teste.processor.PasswordValidatorProcessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/controller")
class PasswordValidatorController @Autowired constructor(private val service: PasswordValidatorProcessor){

    @GetMapping(value = ["/{validatePassword}"])
    fun getValidatePassword(@RequestParam("password") password: String): ResponseEntity<Boolean> {
        return try {
            val isValid = service.validate(password)
            ResponseEntity(isValid, if (!isValid) HttpStatus.BAD_REQUEST else HttpStatus.OK)
        } catch (e: Exception){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
    }
}