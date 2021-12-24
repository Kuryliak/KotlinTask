package pkg.controllers

import pkg.dao.UserDao
import io.jooby.annotations.GET
import io.jooby.annotations.POST
import io.jooby.annotations.Path
import pkg.model.UserModel
import pkg.model.UserService
import javax.inject.Inject

@Path("/user")
class UserController @Inject constructor(
    private val userService: UserService
) {
    @GET
    fun getUser() = userService.allUsers()

    @POST
    fun saveUser(userModel: UserModel) = userService.save(userModel)
}