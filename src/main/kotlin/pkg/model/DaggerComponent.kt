package pkg.model

import dagger.Component
import pkg.dao.UserDao

@Component
interface DaggerComponent {
    fun getUserModel(): UserModel
    fun getUserDao(): UserDao
    fun getUserService(): UserService
}