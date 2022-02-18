package backend.infrastructure.config

import dagger.Component
import backend.infrastructure.api.UserController
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getUserController(): UserController
}