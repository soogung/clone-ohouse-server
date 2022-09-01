package com.soogung.ohouse.user.service

import com.soogung.ohouse.user.domain.repository.UserRepository
import com.soogung.ohouse.user.presentation.dto.request.JoinUserRequest
import org.springframework.stereotype.Service

@Service
class JoinService(private val userRepository: UserRepository) {

    fun execute(request: JoinUserRequest) {
        // TODO :: password encoder
        userRepository.save(request.toEntity("1234"))
    }
}