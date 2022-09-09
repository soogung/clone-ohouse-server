package com.soogung.ohouse.domain.user.exception

import com.soogung.ohouse.global.error.exception.ErrorCode
import com.soogung.ohouse.global.error.exception.OhouseException

object PasswordMismatchException: OhouseException(ErrorCode.PASSWORD_MISMATCH) {
    val EXCEPTION by lazy { this }
}