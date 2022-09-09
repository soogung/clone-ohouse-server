package com.soogung.ohouse.domain.user.facade

import com.soogung.ohouse.domain.user.domain.User
import com.soogung.ohouse.domain.user.domain.repository.UserRepository
import com.soogung.ohouse.domain.user.exception.UserAlreadyExistsException
import com.soogung.ohouse.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserFacade(
    val userRepository: UserRepository,
) {

    @Transactional(readOnly = true)
    fun findUserByEmail(email: String): User {
        return userRepository.findUserByEmail(email)
            ?: throw UserNotFoundException.EXCEPTION
    }

    @Transactional(readOnly = true)
    fun validateExistsByEmail(email: String) {
        if (userRepository.existsUserByEmail(email)) {
            throw UserAlreadyExistsException.EXCEPTION
        }
    }
}