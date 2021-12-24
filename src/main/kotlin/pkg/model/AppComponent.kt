package pkg.model

import dagger.Component
import pkg.controllers.UserController
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getUserController(): UserController
}