package controllers

import dao.UserDao
import io.jooby.annotations.GET
import io.jooby.annotations.POST
import io.jooby.annotations.Path
import model.UserModel
import javax.inject.Inject

@Path("/user")
class UserController @Inject constructor(
    private val userDao: UserDao = UserDao()
) {
    @GET
    fun getUser() = userDao.getAllUsers

    @POST
    fun saveUser(userModel: UserModel) = userDao.save(userModel)
}