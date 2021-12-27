package backend.infrastructure.config

import backend.domain.UserModel
import dagger.Module
import dagger.Provides
import backend.infrastructure.dao.Dao
import backend.infrastructure.dao.EbeanUserDao
import backend.infrastructure.storage.DatabaseConfig

@Module
class AppModule {
    @Provides
    fun blindDao(ebeanUserDao: EbeanUserDao): Dao<UserModel> = ebeanUserDao

    @Provides
    fun database() = DatabaseConfig.database
}
