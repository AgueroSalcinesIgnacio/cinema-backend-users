package com.cinema.users.model.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Getter
import lombok.Setter
import lombok.ToString
import java.time.LocalDateTime

@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
data class UserResponse(
    val id: Long?,
    val username: String,
    var password: String,
    var email: String?,
    var createdDate:LocalDateTime
)

