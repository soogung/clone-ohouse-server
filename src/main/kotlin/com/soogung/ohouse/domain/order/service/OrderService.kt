package com.soogung.ohouse.domain.order.service

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.order.domain.repository.OrderBlockRepository
import com.soogung.ohouse.domain.order.domain.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderBlockRepository: OrderBlockRepository,
) {
    fun execute(carts: List<Cart>) {

    }
}