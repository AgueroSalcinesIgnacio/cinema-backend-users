package com.cinema.users.model.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Getter
import lombok.Setter
import lombok.ToString

@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
data class UserRequest(
    val username: String,
    var password: String,
    var email: String
)

