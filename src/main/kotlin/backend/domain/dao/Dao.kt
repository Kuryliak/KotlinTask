package backend.domain.dao

interface Dao<T> {
    val getUsers: List<T>?
    fun save(t: T)
}