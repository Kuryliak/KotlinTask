package backend.app

import backend.infrastructure.dao.Dao
import backend.domain.AgeToSmallException
import backend.domain.NameException
import backend.domain.UserModel
import backend.infrastructure.api.common.Mapper
import backend.infrastructure.api.common.UserDTO
import javax.inject.Inject

open class UserService @Inject constructor(
    private val userDao: Dao<UserDTO>,
    private val mapper: Mapper
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
        val mappedUser = mapper.toUser(usr)

        userDao.save(mappedUser)
    }

    companion object {
        private var MIN_AGE: Int = 14;
    }
}