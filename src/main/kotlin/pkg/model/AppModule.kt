package pkg.model

import dagger.Module
import dagger.Provides
import io.ebean.Database
import pkg.dao.Dao
import pkg.dao.EbeanUserDao
import pkg.storage.DatabaseConfig

@Module
class AppModule {
    @Provides
    fun blindDao(ebeanUserDao: EbeanUserDao): Dao<UserModel> = ebeanUserDao

    @Provides
    fun database() = DatabaseConfig.database
}
