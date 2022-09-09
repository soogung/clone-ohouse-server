package com.soogung.ohouse.global.security.jwt.exception

import com.soogung.ohouse.global.error.exception.ErrorCode
import com.soogung.ohouse.global.error.exception.OhouseException

object InvalidTokenException: OhouseException(ErrorCode.INVALID_TOKEN) {
    val EXCEPTION by lazy { this }
}