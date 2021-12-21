package model

import javax.persistence.Entity

@Entity
data class UserModel(
    val age: Byte,
    val name: String,
)
