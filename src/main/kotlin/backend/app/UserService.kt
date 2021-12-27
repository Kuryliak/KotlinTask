package backend.app

import backend.domain.UserModel
import javax.inject.Inject

open class UserService @Inject constructor(
    private val userDao: Dao<UserModel>
) {
    fun getAllUsers() = userDao.getUsers()

    fun save(usr: UserModel): UserModel {
        userDao.save(usr)
        return usr
    }
}