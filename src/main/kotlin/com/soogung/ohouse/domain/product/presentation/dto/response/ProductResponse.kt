package com.soogung.ohouse.domain.product.presentation.dto.response

import com.soogung.ohouse.domain.product.domain.Product

data class ProductResponse(
    val id: Long,
    val name: String,
    val company: String,
    val isDiscount: Boolean,
    val discountDegree: Double?,
    val mainImage: ProductImageResponse,
) {

    companion object {
        fun of(product: Product): ProductResponse {
            return ProductResponse(
                id = product.id!!,
                name = product.name,
                company = product.company,
                isDiscount = product.isDiscount,
                discountDegree = product.discountDegree,
                mainImage = ProductImageResponse.of(product.images[0])
            )
        }
    }
}