package pkg.dao

import pkg.exc.AgeToSmallException
import pkg.exc.NameException
import pkg.model.UserModel


open class UserDao : UserDaoInterface<UserModel> {

    private val users: MutableList<UserModel> = ArrayList()

    override val getAllUsers: List<UserModel>?
        get() = users

    override fun save(usr: UserModel) {
        if (usr.age < 14) {
            throw AgeToSmallException(14, "Age is too small")
        }
        if (!usr.name.any { it.isWhitespace() }) {
            throw NameException("name should contain 2 words")
        }
        users.add(usr)
    }
}



