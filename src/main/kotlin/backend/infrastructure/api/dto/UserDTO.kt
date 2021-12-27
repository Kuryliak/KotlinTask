package backend.infrastructure.api.dto

import backend.domain.UserModel

data class UserDTO(
    val name: String,
    val age: Int,
) {
    fun toDomain() = UserModel(age, name)

    companion object {
        fun fromDomain(userModel: UserModel) = UserDTO(userModel.name, userModel.age)
    }
}