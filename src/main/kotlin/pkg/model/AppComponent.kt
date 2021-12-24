package pkg.model

import dagger.Component
import pkg.controllers.UserController
import javax.inject.Singleton

@Singleton
@Component(modules = [ AppModule::class ]) // Like ApplicationContext
interface AppComponent {
    // like getBean(UserController::class)
    fun getUserController(): UserController
}