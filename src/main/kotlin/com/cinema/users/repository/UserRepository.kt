package com.cinema.users.repository

import com.cinema.users.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun  findOneByEmail(email:String):Optional<User>
}