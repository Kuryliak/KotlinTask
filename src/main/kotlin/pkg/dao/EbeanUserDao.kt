package pkg.dao

import pkg.model.UserModel
import javax.inject.Inject

open class EbeanUserDao @Inject constructor() : UserDaoInterface<UserModel> {
    private val users: MutableList<UserModel> = ArrayList()

    override val getAllUsers: List<UserModel>?
        get() = users

    override fun save(usr: UserModel) {
        val jdbc =
        users.add(usr)
    }
}



