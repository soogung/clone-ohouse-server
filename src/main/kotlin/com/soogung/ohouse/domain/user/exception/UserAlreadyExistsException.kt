package com.soogung.ohouse.domain.user.exception

import com.soogung.ohouse.global.error.exception.ErrorCode
import com.soogung.ohouse.global.error.exception.OhouseException

object UserAlreadyExistsException: OhouseException(ErrorCode.USER_ALREADY_EXISTS) {
    val EXCEPTION by lazy { this }
}