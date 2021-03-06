package backend.infrastructure.api

import backend.domain.DomainException
import backend.infrastructure.api.dto.MainErrorDTO
import io.jooby.Context
import io.jooby.ErrorHandler
import io.jooby.StatusCode
import mu.KotlinLogging

object ExceptionHandler : ErrorHandler {
    override fun apply(ctx: Context, cause: Throwable, code: StatusCode) {
        log.error("", cause)
        when (cause) {
            is DomainException -> ctx.responseCode = StatusCode.BAD_REQUEST
            else -> ctx.responseCode = StatusCode.SERVER_ERROR
        }
        ctx.render(MainErrorDTO.fromException(cause))
    }

    private val log = KotlinLogging.logger {}
}