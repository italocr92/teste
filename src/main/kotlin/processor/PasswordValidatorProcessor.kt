package processor

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import services.PasswordValidatorInterface

@Service
class PasswordValidatorProcessor @Autowired constructor(
    private val passwordValidatorInterface: List<PasswordValidatorInterface>):
    PasswordValidatorProcessorInterface {

    override fun validate(password: String): Boolean {
        return passwordValidatorInterface.all{it -> it.isValid(password)}
    }

}