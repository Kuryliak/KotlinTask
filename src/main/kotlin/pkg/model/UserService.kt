package pkg.model

import pkg.dao.UserDao
import pkg.exc.AgeToSmallException
import pkg.exc.NameException
import javax.inject.Inject

open class UserService : UserDao {
    @Inject
    constructor(userDao: UserDao)

    override fun save(usr: UserModel) {
        if (usr.age < 14) {
            throw AgeToSmallException(14, "age to small")
        }
        if (!usr.name.trim().any { it.isWhitespace() }) {
            throw NameException("name should contain 2 words")
        }
        super.save(usr)
    }
}