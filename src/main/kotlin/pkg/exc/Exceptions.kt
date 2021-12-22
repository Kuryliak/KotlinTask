package pkg.exc

open class DomainException(
    override val message: String,
    override val cause: Throwable? = null
) : Exception(message, cause)

open class AgeToSmallException(
    override val message: String,
    override val cause: Throwable? = null
) : DomainException(message, cause)

open class NameException(
    override val message: String,
    override val cause: Throwable? = null
) : DomainException(message, cause)