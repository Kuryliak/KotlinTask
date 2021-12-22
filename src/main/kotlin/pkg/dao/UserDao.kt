package pkg.dao

import pkg.exc.AgeToSmallException
import pkg.exc.NameException
import pkg.model.UserModel


open class UserDao : UserDaoInterface<UserModel> {

    private val users: MutableList<UserModel> = ArrayList()

    override val getAllUsers: List<UserModel>?
        get() = users

    override fun save(usr: UserModel) {
        if (usr.age < 14) {
            throw AgeToSmallException("Age is too small")
        }
        if (!usr.name.any { it.isWhitespace() }) {
            throw NameException("name should contain 2 words")
        }
        users.add(usr)
    }


//    @Inject
//    val database = DB.getDefault()

//
//    fun postUser(username: String, age: Byte) {
//        val usr = UserModel(age, username)
//        if (age < 14) {
//            throw AgeToSmallException("Age is Really Small")
//        }
//        if ("/^\\s*\\S+(?:\\s+\\S+)+\\s*$/g".toRegex().containsMatchIn(username)) {
//            throw NameException("we need more than 1 word in your name")
//        }
//        //     DB.save(usr)
//    }

}

