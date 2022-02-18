package backend.app

interface Dao<T> {
    fun getUsers(): Collection<T>
    fun save(t: T)
}