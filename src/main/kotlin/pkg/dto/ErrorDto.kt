package pkg.dto

import com.fasterxml.jackson.annotation.JsonInclude
import pkg.exc.AgeToSmallException
import pkg.exc.NameException

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorDto(
    val code: String?,
    val message: String?,
    val minAge: Int?

) {
    companion object {
        fun fromException(th: Throwable) = when (th) {
            is AgeToSmallException -> ErrorDto(
                null, th.localizedMessage, th.minAge
            )
            is NameException -> ErrorDto(
                "WRONG NAME",
                "NAME SHOULD CONTAINS MORE THAN 1 WORD", null
            )
            else -> {
                ErrorDto("SERVER_ERROR", "SOME_SERVER_ERROR_IDK", null)
            }
        }
    }
}
