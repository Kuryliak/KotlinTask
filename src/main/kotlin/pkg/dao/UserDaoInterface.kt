package pkg.dao

interface UserDaoInterface<T> {
    val getUsers: List<T>?
    fun save(t: T)
}