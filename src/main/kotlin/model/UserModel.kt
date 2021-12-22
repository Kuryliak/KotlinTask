package model

import javax.persistence.Entity

@Entity
data class UserModel(
    val age: Int,
    val name: String
)
