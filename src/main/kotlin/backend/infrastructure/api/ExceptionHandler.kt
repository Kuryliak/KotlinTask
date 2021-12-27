package backend.infrastructure.api

import io.jooby.Context
import io.jooby.ErrorHandler
import io.jooby.StatusCode
import mu.KotlinLogging
import backend.exception.DomainException
import backend.infrastructure.api.dto.MainErrorDTO

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