package com.cinema.users.service

import com.cinema.users.model.dto.UserRequest
import com.cinema.users.model.dto.UserResponse

interface UserService {
    fun saveUser(user:UserRequest): UserResponse
     fun findByEmail(email: String): UserResponse
     fun findAllUsers(): List<UserResponse>
}