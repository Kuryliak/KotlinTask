package backend.domain

import dagger.Module
import dagger.Provides
import backend.domain.dao.Dao
import backend.domain.dao.EbeanUserDao
import backend.infrastructure.api.common.UserDTO
import backend.infrastructure.storage.DatabaseConfig

@Module
class AppModule {
    @Provides
    fun blindDao(ebeanUserDao: EbeanUserDao): Dao<UserDTO> = ebeanUserDao

    @Provides
    fun database() = DatabaseConfig.database
}
