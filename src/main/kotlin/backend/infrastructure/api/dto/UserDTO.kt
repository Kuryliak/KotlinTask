package backend.infrastructure.api.dto

import backend.domain.UserModel

data class UserDTO(
    val fullName: String,
    val age: Int,
) {
    fun toDomain() = UserModel(age, fullName)

    companion object {
        fun fromDomain(userModel: UserModel) = UserDTO(userModel.name, userModel.age)
    }
}