package com.soogung.ohouse.domain.cart.presentation.dto.response

import com.soogung.ohouse.domain.product.presentation.dto.response.ProductDeliveryResponse
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductImageResponse

data class CartProductResponse(
    val id: Long,
    val name: String,
    val image: ProductImageResponse,
    val deliveryResponse: ProductDeliveryResponse,
    val detailProducts: List<CartDetailProductResponse>,
)