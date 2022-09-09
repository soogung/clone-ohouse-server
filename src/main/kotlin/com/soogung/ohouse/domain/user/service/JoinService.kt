package com.soogung.ohouse.domain.user.service

import com.soogung.ohouse.domain.user.domain.repository.UserRepository
import com.soogung.ohouse.domain.user.presentation.dto.request.JoinUserRequest
import org.springframework.stereotype.Service

@Service
class JoinService(private val userRepository: UserRepository) {

    fun execute(request: JoinUserRequest) {
        // TODO :: password encoder
        userRepository.save(request.toEntity("1234"))
    }
}