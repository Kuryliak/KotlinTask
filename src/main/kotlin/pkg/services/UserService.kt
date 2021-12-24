package pkg.services

import pkg.dao.UserDaoInterface
import pkg.exc.AgeToSmallException
import pkg.exc.NameException
import pkg.model.UserModel
import javax.inject.Inject

open class UserService @Inject constructor(
    private val userDao: UserDaoInterface<UserModel>
) {
    var minAge: Int = 14;

    fun allUsers() {
        userDao.getUsers
    }

    fun save(usr: UserModel) {
        if (usr.age < minAge) {
            throw AgeToSmallException(minAge, "age to small")
        }
        if (!usr.name.trim().any { it.isWhitespace() }) {
            throw NameException("name should contain 2 words")
        }
        userDao.save(usr)
    }
}