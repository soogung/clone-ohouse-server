package com.soogung.ohouse.domain.product.presentation.dto.response

import com.soogung.ohouse.domain.product.domain.Product

data class ProductDetailResponse(
    val name: String,
    val isDiscount: Boolean,
    val discountDegree: Double?,
    val images: List<ProductImageResponse>,
    val options: List<ProductOptionResponse>,
    val delivery: ProductDeliveryResponse,
) {
    companion object {
        fun of(product: Product): ProductDetailResponse {
            return ProductDetailResponse(
                name = product.name,
                isDiscount = product.isDiscount,
                discountDegree = product.discountDegree,
                images = product.images.map(ProductImageResponse::of),
                options = product.options.map(ProductOptionResponse::of),
                delivery = ProductDeliveryResponse.of(product.delivery),
            )
        }
    }
}