package backend.infrastructure.dao.ebean

import backend.domain.UserModel
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class MappedUser(
    @Id
    val name: String,
    val userAge: Int,
) {
    fun toDomain() = UserModel(userAge, name)

    companion object {
        fun fromDomain(userModel: UserModel) = MappedUser(userModel.name, userModel.age)
    }
}
