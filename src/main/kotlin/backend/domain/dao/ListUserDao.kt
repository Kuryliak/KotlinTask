package backend.domain.dao

import backend.infrastructure.api.common.UserDTO
import javax.inject.Inject

open class ListUserDao @Inject constructor() : Dao<UserDTO> {
    private val users: MutableList<UserDTO> = ArrayList()

    override val getUsers: List<UserDTO>?
        get() = users


    override fun save(usr: UserDTO) {
        users.add(usr)
    }
}