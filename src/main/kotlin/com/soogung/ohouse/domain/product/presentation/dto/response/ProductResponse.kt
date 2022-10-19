package com.soogung.ohouse.domain.product.presentation.dto.response

data class ProductResponse(
    val id: Long,
    val name: String,
    val company: String,
    val isDiscount: Boolean,
    val discountDegree: Int?,
    val mainImage: ProductImageResponse,
    val price: Int,
    val discountedPrice: Int?,
)