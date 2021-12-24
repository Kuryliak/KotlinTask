package pkg

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.jooby.OpenAPIModule
import io.jooby.json.JacksonModule
import io.jooby.runApp
import mu.KotlinLogging
import pkg.controllers.ExceptionHandler
import pkg.model.DaggerAppComponent


fun main(args: Array<String>) {
    log.debug { "Started" }
    runApp(args) {
        // the same as SpringBootApplication.run()
        val container = DaggerAppComponent.create()

        // the same as applicationContext.getBean(UserController.class)
        val userController = container.getUserController()

        install(OpenAPIModule())
        install(JacksonModule(jacksonObjectMapper())) // fixes the problem but looks more like workaround than a solution

        mvc(userController)
        error(Throwable::class.java, ExceptionHandler)
        assets("/index", "/index.html")
    }
}

private val log = KotlinLogging.logger {}