package pkg.model

import pkg.dao.UserDaoInterface
import pkg.exc.AgeToSmallException
import pkg.exc.NameException
import javax.inject.Inject
import javax.inject.Singleton

// TODO: dependency inversion
@Singleton
open class UserService @Inject constructor(
    private val userDao: UserDaoInterface<UserModel>
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