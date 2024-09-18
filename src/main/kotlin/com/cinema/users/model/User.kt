package com.cinema.users.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") var id: Long?,
    @Column(name = "username") var username: String,
    @Column(name = "password_hash") var password: String,
    @Column(name = "email") var email: String?,
    @Column(name = "created_at") var createdDate: LocalDateTime
)