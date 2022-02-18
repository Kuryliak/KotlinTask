package backend.infrastructure.api.dto

import com.fasterxml.jackson.annotation.JsonInclude
import backend.domain.AgeToSmallException
import backend.domain.NameException

data class MainErrorDTO(
    val code: String,
    val message: String?,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val minAge: Int?
) {
    companion object {
        fun fromException(th: Throwable) = when (th) {
            is AgeToSmallException -> MainErrorDTO(th.message, th.localizedMessage, th.minAge)
            is NameException -> MainErrorDTO(
                "WRONG NAME",
                "NAME SHOULD CONTAINS MORE THAN 1 WORD",
                null
            )
            else -> {
                MainErrorDTO(
                    "SERVER_ERROR",
                    "SERVER_ERROR_FIX_SOMETHING",
                    null
                )
            }
        }
    }
}
