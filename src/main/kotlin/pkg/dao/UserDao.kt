package pkg.dao

import pkg.model.UserModel
import javax.inject.Inject

open class UserDao @Inject constructor() : UserDaoInterface<UserModel> {
    private val users: MutableList<UserModel> = ArrayList()

    override val getUsers: List<UserModel>?
        get() = users

    override fun save(usr: UserModel) {
        users.add(usr)
    }
}