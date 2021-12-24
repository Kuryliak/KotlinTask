package pkg.model

import dagger.Module
import dagger.Provides
import pkg.dao.UserDao
import pkg.dao.UserDaoInterface

@Module
class AppModule {
    @Provides
    fun blindDao(userDao: UserDao): UserDaoInterface<UserModel> = userDao
}