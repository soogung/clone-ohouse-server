package com.soogung.ohouse.domain.cart.exception

import com.soogung.ohouse.global.error.exception.ErrorCode
import com.soogung.ohouse.global.error.exception.OhouseException

object CartNotFoundException: OhouseException(ErrorCode.CART_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}