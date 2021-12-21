package dao

import exc.AgeToSmallException
import exc.NameException
import io.ebean.DB
import model.UserModel
import javax.inject.Inject

open class UserDao {
    @Inject
    val database = DB.getDefault()

    @Inject
    fun getUsers(): List<UserModel> {
        return DB.find(UserModel::class.java).findList()
    }

    @Inject
    fun postUser(username: String, age: Byte) {
        val usr = UserModel(age, username)
        if (age < 14) {
            throw AgeToSmallException("Age is Really Small")
        }
        if ("/^\\s*\\S+(?:\\s+\\S+)+\\s*$/g".toRegex().containsMatchIn(username)) {
            throw NameException("we need more than 1 word in your name")
        }
        DB.save(usr)
    }
}