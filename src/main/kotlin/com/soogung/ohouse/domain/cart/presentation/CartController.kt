package com.soogung.ohouse.domain.cart.presentation

import com.soogung.ohouse.domain.cart.service.PutProductService
import com.soogung.ohouse.domain.cart.service.QueryCartService
import com.soogung.ohouse.domain.cart.service.UpdateQuantityService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cart/{userId}")
class CartController(
    private val queryCartService: QueryCartService,
    private val putProductService: PutProductService,
    private val updateQuantityService: UpdateQuantityService,
) {
}