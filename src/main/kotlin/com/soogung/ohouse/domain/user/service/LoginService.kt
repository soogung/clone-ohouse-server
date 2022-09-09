package com.soogung.ohouse.domain.user.service

import com.soogung.ohouse.domain.user.exception.PasswordMismatchException
import com.soogung.ohouse.domain.user.facade.UserFacade
import com.soogung.ohouse.domain.user.presentation.dto.request.LoginUserRequest
import com.soogung.ohouse.domain.user.presentation.dto.response.TokenResponse
import com.soogung.ohouse.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    fun execute(request: LoginUserRequest): TokenResponse {
        val user = userFacade.findUserByEmail(request.email)
        checkPassword(request.password, user.password)

        return TokenResponse(jwtTokenProvider.createAccessToken(request.email))
    }

    private fun checkPassword(actual: String, expected: String) {
        if (!passwordEncoder.matches(actual, expected)) {
            throw PasswordMismatchException.EXCEPTION
        }
    }
}