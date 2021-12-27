package backend.infrastructure

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.jooby.OpenAPIModule
import io.jooby.json.JacksonModule
import io.jooby.runApp
import mu.KotlinLogging
import backend.infrastructure.helper.ExceptionHandler
import backend.infrastructure.config.DaggerAppComponent


fun main(args: Array<String>) {
    log.debug { "Started" }
    runApp(args) {
        install(OpenAPIModule())
        install(JacksonModule(jacksonObjectMapper())) // fixes the problem but looks more like workaround than a solution

        val container = DaggerAppComponent.create()
        val userService = container.getUserController()

        mvc(userService)
        error(Throwable::class.java, ExceptionHandler)
        assets("/index", "/index.html")
    }
}

private val log = KotlinLogging.logger {}