package backend.app

import backend.domain.dao.Dao
import backend.exception.AgeToSmallException
import backend.exception.NameException
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
        userDao.save(mapper.toDto(usr))
    }

    companion object {
        private var MIN_AGE: Int = 14;
    }
}