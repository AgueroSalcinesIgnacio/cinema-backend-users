package com.cinema.users.service.impl

import com.cinema.users.config.error.exception.GenericException
import com.cinema.users.model.dto.UserRequest
import com.cinema.users.model.dto.UserResponse
import com.cinema.users.model.mapper.toEntity
import com.cinema.users.model.mapper.toResponse
import com.cinema.users.repository.UserRepository
import com.cinema.users.service.UserService
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun saveUser(user: UserRequest): UserResponse {
        return try {
            userRepository.save(user.toEntity()).toResponse()
        } catch (exception: DataIntegrityViolationException) {
            throw GenericException(exception.message);
        }
    }

    override fun findByEmail(email: String): UserResponse {
        return try {
            userRepository.findOneByEmail(email).orElseThrow().toResponse()
        } catch (exception: NoSuchElementException) {
            throw GenericException(exception.message);
        }
    }

    override fun findAllUsers(): List<UserResponse> {
        return userRepository.findAll().map { it -> it.toResponse() }.toList()
    }
}