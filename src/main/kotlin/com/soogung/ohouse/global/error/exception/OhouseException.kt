package com.soogung.ohouse.global.error.exception

open class OhouseException(
    val errorCode: ErrorCode,
    message: String,
): RuntimeException(message) {
    constructor(errorCode: ErrorCode): this(errorCode, errorCode.message)
}