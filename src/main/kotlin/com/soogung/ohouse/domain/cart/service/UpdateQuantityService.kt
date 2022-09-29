package com.soogung.ohouse.domain.cart.service

import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import org.springframework.stereotype.Service

@Service
class UpdateQuantityService(
    private val cartRepository: CartRepository,
) {
    fun execute() {

    }
}