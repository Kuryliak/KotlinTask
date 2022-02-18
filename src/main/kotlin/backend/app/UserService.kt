package backend.app

import backend.domain.UserModel
import javax.inject.Inject

open class UserService @Inject constructor(
    private val userDao: Dao<UserModel>
) {
    fun getAllUsers() = userDao.getUsers()

    fun save(age: Int, name: String): UserModel {
        val user = UserModel.createValidated(age, name)
        userDao.save(user)
        return user
    }
}