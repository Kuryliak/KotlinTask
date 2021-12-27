package backend.infrastructure.api.common

import backend.domain.UserModel
import javax.inject.Inject
class Mapper @Inject constructor() {
    fun toDto(user: UserModel): UserDTO {
        val name: String = user.name
        val age: Int = user.age
        return UserDTO(name, age)
    }

    fun toUser(user: UserModel): UserDTO {
        return UserDTO(user.name, user.age)
    }
}