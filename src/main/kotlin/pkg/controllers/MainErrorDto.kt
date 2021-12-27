package pkg.controllers

import com.fasterxml.jackson.annotation.JsonInclude
import pkg.exception.AgeToSmallException
import pkg.exception.NameException

data class MainErrorDto(
    val code: String,
    val message: String?,
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
                    "SERVER_ERROR_FIX_SOMETHING",
                    null
                )
            }
        }
    }
}
