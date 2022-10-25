package com.soogung.ohouse.domain.cart.presentation.dto.response

data class CartDetailProductResponse(
    val cartId: Long,
    val productName: String,
    val quantity: Int,
)