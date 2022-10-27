package com.soogung.ohouse.domain.product.presentation.dto.response

data class ProductDetailResponse(
    val name: String,
    val isDiscount: Boolean,
    val discountDegree: Int?,
    val price: Int,
    val discountPrice: Int,
    val company: String,
    val images: List<ProductImageResponse>,
    val options: List<ProductOptionResponse>,
    val delivery: ProductDeliveryResponse,
)