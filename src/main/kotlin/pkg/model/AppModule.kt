package pkg.model

import dagger.Module
import dagger.Provides
import pkg.dao.ListUserDao
import pkg.dao.UserDaoInterface

@Module // the same as @Configuration in Spring
class AppModule {
    // the same as @Bean
//    @Provides
//    fun bindDao(): UserDaoInterface<UserModel> = ListUserDao()

    // The same as above
    @Provides
    fun bindDao(listUserDao: ListUserDao): UserDaoInterface<UserModel> = listUserDao
}