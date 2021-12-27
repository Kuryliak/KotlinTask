package backend.domain

import backend.app.UserService
import backend.exception.AgeToSmallException
import backend.exception.NameException

data class UserModel(
    val age: Int,
    val name: String
) {
    companion object {
        private val MIN_AGE = 14

        fun createValidated(
            age: Int,
            name: String
        ): UserModel {
            if (age < MIN_AGE) {
                throw AgeToSmallException(MIN_AGE, "age to small")
            }
            if (!name.trim().any { it.isWhitespace() }) {
                throw NameException("name should contain 2 words")
            }
            return UserModel(age, name)
        }

    }
}