package pkg.controllers

import pkg.exc.AgeToSmallException
import pkg.exc.NameException
import io.jooby.Context
import io.jooby.ErrorHandler
import io.jooby.StatusCode
import mu.KotlinLogging
object ExceptionHandler : ErrorHandler {
    override fun apply(ctx: Context, cause: Throwable, code: StatusCode) {
        if (cause is Exception) {
            log.debug(cause) { "lower than 14 please come back later" }
        } else if (cause is NameException) {
            log.error(cause) { "Name contains only 1 word" }
        }
        log.error("", cause)
        when (cause) {
            is AgeToSmallException -> ctx.responseCode = StatusCode.BAD_REQUEST
            is NameException -> ctx.responseCode = StatusCode.BAD_REQUEST
            else -> ctx.responseCode = StatusCode.SERVER_ERROR
        }
        ctx.render(MainErrorDto.fromException(cause))

    }

    private val log = KotlinLogging.logger {}
}