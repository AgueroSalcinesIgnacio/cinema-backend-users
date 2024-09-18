package com.cinema.users.controller

import com.cinema.users.config.error.exception.GenericException
import com.cinema.users.model.dto.UserRequest
import com.cinema.users.model.dto.UserResponse
import com.cinema.users.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @GetMapping
    fun findAllUsers(): ResponseEntity<List<UserResponse>> {
        return ResponseEntity.ok(userService.findAllUsers())
    }

    @PostMapping
    fun saveUser(@RequestBody user: UserRequest): ResponseEntity<UserResponse> {
        return try {
            ResponseEntity.ok(userService.saveUser(user))
        } catch (exception: Exception) {
            throw GenericException(exception.message)
        }
    }

    @GetMapping("/emails/{email}")
    fun findByEmail(@PathVariable("email") email: String): ResponseEntity<UserResponse> {
        return try {
            ResponseEntity.ok(userService.findByEmail(email))
        } catch (exception: Exception) {
            throw GenericException(exception.message)
        }
    }
}