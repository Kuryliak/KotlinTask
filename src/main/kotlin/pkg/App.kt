package pkg

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import pkg.controllers.UserController
import io.jooby.OpenAPIModule
import io.jooby.json.JacksonModule
import io.jooby.runApp
import mu.KotlinLogging
import pkg.controllers.ExceptionHandler
import pkg.controllers.MainErrorDto
import pkg.dao.UserDao
import pkg.model.UserService


fun main(args: Array<String>) {
    log.debug { "Started" }
    runApp(args) {
        install(OpenAPIModule())
        install(JacksonModule(jacksonObjectMapper())) // fixes the problem but looks more like workaround than a solution

        mvc(UserController(userService = UserService(UserDao())))
        error(Throwable::class.java, ExceptionHandler)
        assets("/index", "/index.html")
    }
}

private val log = KotlinLogging.logger {}