package pkg.controllers

import com.fasterxml.jackson.annotation.JsonInclude
import pkg.exc.AgeToSmallException
import pkg.exc.NameException

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MainErrorDto(
    val code: String,
    val message: String?,
    val minAge: Int?

) {
    companion object {
        fun fromException(th: Throwable) = when (th) {
            is AgeToSmallException -> MainErrorDto(th.message, th.localizedMessage, th.minAge)
            is NameException -> MainErrorDto(
                "WRONG NAME",
                "NAME SHOULD CONTAINS MORE THAN 1 WORD",
                null
            )
            else -> {
                MainErrorDto(
                    "SERVER_ERROR",
                    "SOME_SERVER_ERROR_IDK",
                    null
                )
            }
        }
    }
}
