package com.soogung.ohouse.domain.user.presentation.dto.request

import com.soogung.ohouse.domain.user.domain.User
import com.soogung.ohouse.domain.user.domain.type.UserGrade

data class JoinUserRequest(
    val email: String,
    val password: String,
    val nickname: String
) {
    fun toEntity(encodedPassword: String): User {
        return User(email, encodedPassword, nickname, UserGrade.NORMAL)
    }
}
