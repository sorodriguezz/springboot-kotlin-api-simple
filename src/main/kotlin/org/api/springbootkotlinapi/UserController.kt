package org.api.springbootkotlinapi

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping
    fun getAllUsers(): List<User> = userRepository.findAll()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User =
        userRepository.findById(id).orElseThrow { Exception("User not found") }

    @PostMapping
    fun createUser(@RequestBody user: User): User = userRepository.save(user)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody updatedUser: User): User {
        val user = userRepository.findById(id).orElseThrow { Exception("User not found") }
        user.name = updatedUser.name
        user.email = updatedUser.email
        return userRepository.save(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        val user = userRepository.findById(id).orElseThrow { Exception("User not found") }
        userRepository.delete(user)
    }
}