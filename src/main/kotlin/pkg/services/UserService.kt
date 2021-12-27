package pkg.services

import pkg.dao.Dao
import pkg.exception.AgeToSmallException
import pkg.exception.NameException
import pkg.model.UserModel
import javax.inject.Inject

open class UserService @Inject constructor(
    private val userDao: Dao<UserModel>,
) {
    fun allUsers() {
        userDao.getUsers
    }

    fun save(usr: UserModel) {
        if (usr.age < MIN_AGE) {
            throw AgeToSmallException(MIN_AGE, "age to small")
        }
        if (!usr.name.trim().any { it.isWhitespace() }) {
            throw NameException("name should contain 2 words")
        }
        userDao.save(usr)
    }
    companion object {
        private var MIN_AGE: Int = 14;
    }
}