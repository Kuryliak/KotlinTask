package backend.infrastructure.dao

interface Dao<T> {
    val getUsers: List<T>?
    fun save(t: T)
}