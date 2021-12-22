package dao

interface UserDaoInterface<T> {

    val getAllUsers: List<T>?

    fun save(t: T)
}