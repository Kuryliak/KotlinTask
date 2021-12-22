package pkg

import pkg.controllers.ExceptionHandler
import pkg.controllers.UserController
import io.jooby.OpenAPIModule
import io.jooby.json.JacksonModule
import io.jooby.runApp
import mu.KotlinLogging


fun main(args: Array<String>) {
    log.debug { "Started" }
    runApp(args) {
        install(OpenAPIModule())
        install(JacksonModule())

        mvc(UserController())
        error(Throwable::class.java, ExceptionHandler)
        assets("/index","/index.html")
    }
}

private val log = KotlinLogging.logger {}