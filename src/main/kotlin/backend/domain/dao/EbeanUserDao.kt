package backend.domain.dao

import backend.domain.UserModel
import io.ebean.Database
import javax.inject.Inject

open class EbeanUserDao @Inject constructor(private val database: Database) : Dao<UserModel> {
    override val getUsers: List<UserModel>?
        get() = database.find(UserModel::class.java).findList()

    override fun save(usr: UserModel) {
        database.save(usr)
    }
}
