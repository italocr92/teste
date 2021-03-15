package com.spring.teste.processor

import org.springframework.stereotype.Service

@Service
class PasswordValidatorProcessor{

    fun validate(password: String): Boolean{
         val specialChars = arrayOf('!','@','#','$','%','^','&','*','(',')','_',"+")

        if (password.count { it -> !it.isDigit() } < 1) {
            return false
        }

        if (password.length < 9){
            return false
        }

        if (password.count { it -> !it.isLowerCase() } < 1){
            return false
        }

        val charGroup = password.toCharArray().groupBy { it -> it }
        if (charGroup.any{it -> it.value.count() > 1})
        {
            return false
        }

        if (password.count { it -> specialChars.contains(it)  } < 1){
            return false
        }

        if (password.count { it -> it.isUpperCase() } < 1){
            return false
        }
        return true
    }
}