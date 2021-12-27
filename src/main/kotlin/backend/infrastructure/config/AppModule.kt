package backend.infrastructure.config

import backend.domain.UserModel
import dagger.Module
import dagger.Provides
import backend.app.Dao
import backend.infrastructure.dao.ebean.EbeanUserDao

@Module
class AppModule {
    @Provides
    fun blindDao(ebeanUserDao: EbeanUserDao): Dao<UserModel> = ebeanUserDao

    @Provides
    fun database() = DatabaseConfig.database
}
