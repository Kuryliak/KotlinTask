package backend.infrastructure.dao.ebean

import backend.app.Dao
import backend.domain.UserModel
import io.ebean.Database
import javax.inject.Inject

open class EbeanUserDao @Inject constructor(private val database: Database) : Dao<UserModel> {
    override fun getUsers() = database.find(MappedUser::class.java)
        .findList()
        .map(MappedUser::toDomain)

    override fun save(usr: UserModel) {
        database.insert(MappedUser.fromDomain(usr))
    }
}
