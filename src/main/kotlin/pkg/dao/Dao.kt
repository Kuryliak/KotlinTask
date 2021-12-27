package pkg.dao

interface Dao<T> {
    val getUsers: List<T>?
    fun save(t: T)
}