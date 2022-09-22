package com.soogung.ohouse.domain.product.exception

import com.soogung.ohouse.global.error.exception.ErrorCode
import com.soogung.ohouse.global.error.exception.OhouseException

object ProductNotFoundException: OhouseException(ErrorCode.PRODUCT_NOT_FOUND) {
    val EXCEPTION by lazy { this }
}