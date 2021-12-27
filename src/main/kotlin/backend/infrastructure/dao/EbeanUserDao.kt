package backend.infrastructure.dao

import backend.domain.UserModel
import backend.infrastructure.api.common.UserDTO
import io.ebean.Database
import javax.inject.Inject

open class EbeanUserDao @Inject constructor(private val database: Database) : Dao<UserDTO> {
    override val getUsers: List<UserDTO>?
        get() = database.find(UserDTO::class.java).findList()

    override fun save(usr: UserDTO) {
        database.save(usr)
    }
}
