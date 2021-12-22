import controllers.ExceptionHandler
import controllers.UserController
import io.jooby.OpenAPIModule
import io.jooby.json.JacksonModule
import io.jooby.runApp


fun main(args: Array<String>) {
    runApp(args) {
        install(OpenAPIModule())
        install(JacksonModule())

        mvc(UserController())
        error(Throwable::class.java, ExceptionHandler)
        assets("/index","/index.html")
    }
}