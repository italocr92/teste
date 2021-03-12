package services

interface PasswordValidatorInterface {

    fun isValid(password: String): Boolean
}