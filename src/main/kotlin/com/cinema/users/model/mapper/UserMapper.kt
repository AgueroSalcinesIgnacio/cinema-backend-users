package com.cinema.users.model.mapper

import com.cinema.users.model.User
import com.cinema.users.model.dto.UserRequest
import com.cinema.users.model.dto.UserResponse
import java.time.LocalDateTime

fun User.toResponse(): UserResponse {
    return UserResponse(
        id, username, password, email, createdDate
    )
}

fun UserRequest.toEntity(): User {
    return User(
        id = null, username = username, password = password, email = email, createdDate = LocalDateTime.now()
    )
}
