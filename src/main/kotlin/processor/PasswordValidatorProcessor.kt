package processor

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import services.PasswordValidatorInterface
import java.util.logging.Logger

@Service
class PasswordValidatorProcessor @Autowired constructor(
    private val passwordValidatorInterface: List<PasswordValidatorInterface>):
    PasswordValidatorProcessorInterface {

    val logger: Logger = Logger.getLogger(javaClass.toString())

    override fun validate(password: String) =
            passwordValidatorInterface.all{it -> it.isValid(password)}
}