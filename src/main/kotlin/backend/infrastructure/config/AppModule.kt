package backend.infrastructure.config

import backend.infrastructure.api.common.UserDTO
import backend.infrastructure.dao.Dao
import backend.infrastructure.dao.EbeanUserDao
import backend.infrastructure.storage.DatabaseConfig
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun blindDao(ebeanUserDao: EbeanUserDao): Dao<UserDTO> = ebeanUserDao

    @Provides
    fun database() = DatabaseConfig.database
}
