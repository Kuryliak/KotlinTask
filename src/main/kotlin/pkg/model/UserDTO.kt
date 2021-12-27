package pkg.model

import javax.persistence.Entity

@Entity
data class UserDTO(
    val name: String,
    val age: Int,
)
