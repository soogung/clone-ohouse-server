package com.soogung.ohouse.user.presentation.dto.request

import com.soogung.ohouse.user.domain.User
import com.soogung.ohouse.user.domain.type.UserGrade

data class JoinUserRequest(
    val email: String,
    val password: String,
    val nickname: String
) {
    fun toEntity(encodedPassword: String): User {
        return User(email, encodedPassword, nickname, UserGrade.NORMAL)
    }
}
