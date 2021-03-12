package controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import processor.PasswordValidatorProcessor
import java.awt.PageAttributes
import java.lang.Exception as Exception1


@RestController
@RequestMapping(path = ["controller"])
class PasswordValidatorController @Autowired constructor(private val service: PasswordValidatorProcessor){

    @GetMapping(
        value = ["validatePassword"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getValidatePassword(@RequestParam("password") password: String): ResponseEntity<Boolean> {
        return try {
            val isValid = service.validate(password)
            ResponseEntity(isValid, if (!isValid) HttpStatus.BAD_REQUEST else HttpStatus.OK)
        } catch (e: Exception){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
    }
}