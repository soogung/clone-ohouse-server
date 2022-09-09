package com.soogung.ohouse.domain.user.facade

import com.soogung.ohouse.domain.user.domain.User
import com.soogung.ohouse.domain.user.domain.repository.UserRepository
import com.soogung.ohouse.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class UserFacade(
    val userRepository: UserRepository,
) {
    fun findUserByEmail(email: String): User {
        return userRepository.findUserByEmail(email)
            ?: throw UserNotFoundException.EXCEPTION
    }
}