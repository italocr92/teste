package processor

interface PasswordValidatorProcessorInterface {

    fun validate(password: String): Boolean

}