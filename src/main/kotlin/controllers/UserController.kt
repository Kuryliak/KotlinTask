package controllers

import dao.UserDao
import io.jooby.annotations.ContextParam
import io.jooby.annotations.GET
import io.jooby.annotations.POST

import io.jooby.annotations.Path
import javax.inject.Inject

@Path("/user")
class UserController @Inject constructor(
    private val userDao: UserDao = UserDao()){

    @GET
    fun getUser() {
        userDao.getUsers()
    }

    @POST
    fun postUser(@ContextParam age: Byte, @ContextParam name: String) {
        userDao.postUser(name, age)
    }
}