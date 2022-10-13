package com.soogung.ohouse.domain.product.presentation.dto.response

data class ProductListResponse (
    val products: List<ProductResponse>,
) {
    companion object {
        fun of(products: List<ProductResponse>): ProductListResponse {
            return ProductListResponse(
                products = products
            )
        }
    }
}