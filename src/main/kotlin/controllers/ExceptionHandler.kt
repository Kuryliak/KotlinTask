package controllers

import exc.AgeToSmallException
import exc.NameException
import io.jooby.Context
import io.jooby.ErrorHandler
import io.jooby.StatusCode
import mu.KotlinLogging

object ExceptionHandler : ErrorHandler {
    override fun apply(ctx: Context, cause: Throwable, code: StatusCode) {
        if (cause is Exception) {
            log.debug(cause) { "Age is < 14 " }
        } else if (cause is NameException) {
            log.error(cause) { "Name contains only 1 word" }
        }
        log.error("",cause)
        when (cause) {
            is AgeToSmallException -> ctx.responseCode = StatusCode.BAD_REQUEST
            is NameException -> ctx.responseCode = StatusCode.BAD_REQUEST
            else -> ctx.responseCode = StatusCode.SERVER_ERROR
        }
    }
    private val log = KotlinLogging.logger {}
}