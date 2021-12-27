package backend.infrastructure.api

import backend.app.UserService
import backend.infrastructure.api.dto.UserDTO
import io.jooby.annotations.GET
import io.jooby.annotations.POST
import io.jooby.annotations.Path
import javax.inject.Inject

@Path("/user")
class UserController @Inject constructor(
    private val userService: UserService
) {
    @GET
    fun getUser() = userService.getAllUsers()
        .map(UserDTO.Companion::fromDomain)

    @POST
    fun saveUser(request: UserDTO): UserDTO {
        val result = userService.save(request.age, request.name)
        return UserDTO.fromDomain(result)
    }
}