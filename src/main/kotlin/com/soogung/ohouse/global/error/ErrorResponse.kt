package com.soogung.ohouse.global.error

import com.soogung.ohouse.global.error.exception.ErrorCode

class ErrorResponse(
    val status: Int,
    val message: String,
) {
    constructor(errorCode: ErrorCode): this(errorCode.status, errorCode.message)
}