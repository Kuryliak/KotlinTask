package pkg.model

import pkg.dao.UserDao
import pkg.exc.AgeToSmallException
import pkg.exc.NameException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class UserService @Inject constructor(
    private val userDao: UserDao
) {
    fun allUsers() = userDao.getAllUsers

    fun save(usr: UserModel) {
        if (usr.age < 14) {
            throw AgeToSmallException(14, "age to small")
        }
        if (!usr.name.trim().any { it.isWhitespace() }) {
            throw NameException("name should contain 2 words")
        }
        userDao.save(usr)
    }
}