package backend.infrastructure.api.common

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "USER_MODEL")
data class UserDTO(
    val name: String,
    val age: Int,
)
