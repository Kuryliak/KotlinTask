package backend.domain

open class DomainException(
    override val message: String,
    override val cause: Throwable? = null
) : Exception(message, cause)

open class AgeToSmallException(
    val minAge: Int,
    override val message: String,
    override val cause: Throwable? = null
) : DomainException(message, cause)

open class NameException(
    override val message: String,
    override val cause: Throwable? = null
) : DomainException(message, cause)