package pkg.model

import dagger.Component
import pkg.controllers.UserController
import pkg.dao.UserDao
import javax.inject.Singleton

@Singleton
@Component // the same as @Configuration in Spring
interface AppComponent {
    // the same as @Bean
    fun getUserController(): UserController
}