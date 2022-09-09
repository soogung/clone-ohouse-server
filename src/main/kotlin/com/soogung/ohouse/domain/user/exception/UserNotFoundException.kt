package com.soogung.ohouse.domain.user.exception

import com.soogung.ohouse.global.error.exception.ErrorCode
import com.soogung.ohouse.global.error.exception.OhouseException

object UserNotFoundException: OhouseException(ErrorCode.USER_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}