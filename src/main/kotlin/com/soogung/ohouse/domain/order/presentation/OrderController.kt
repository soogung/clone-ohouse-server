package com.soogung.ohouse.domain.order.presentation

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.order.presentation.dto.request.OrderRequest
import com.soogung.ohouse.domain.order.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(
    private val orderService: OrderService,
) {
    @PostMapping
    fun orderCarts(@RequestBody request: OrderRequest) {
        orderService.execute(request)
    }
}