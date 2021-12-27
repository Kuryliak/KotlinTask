package backend.domain

import dagger.Component
import backend.infrastructure.api.UserController
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getUserController(): UserController
}