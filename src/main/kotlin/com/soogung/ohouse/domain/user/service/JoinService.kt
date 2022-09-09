package com.soogung.ohouse.domain.user.service

import com.soogung.ohouse.domain.user.domain.repository.UserRepository
import com.soogung.ohouse.domain.user.facade.UserFacade
import com.soogung.ohouse.domain.user.presentation.dto.request.JoinUserRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class JoinService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val userFacade: UserFacade,
) {
    fun execute(request: JoinUserRequest) {
        userFacade.validateExistsByEmail(request.email)
        userRepository.save(request.toEntity(
            passwordEncoder.encode(request.password)
        ))
    }
}