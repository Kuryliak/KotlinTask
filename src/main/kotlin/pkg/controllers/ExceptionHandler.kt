package pkg.controllers

import io.jooby.Context
import io.jooby.ErrorHandler
import io.jooby.StatusCode
import mu.KotlinLogging
import pkg.exc.DomainException

object ExceptionHandler : ErrorHandler {
    override fun apply(ctx: Context, cause: Throwable, code: StatusCode) {
        log.error(cause.message, cause)
        when (cause) {
            is DomainException -> ctx.responseCode = StatusCode.BAD_REQUEST
            else -> ctx.responseCode = StatusCode.SERVER_ERROR
        }
        ctx.render(MainErrorDto.fromException(cause))

    }

    private val log = KotlinLogging.logger {}
}