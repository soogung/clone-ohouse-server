package com.soogung.ohouse.domain.product.presentation.dto.response

import com.soogung.ohouse.domain.product.domain.ProductOption

data class ProductOptionResponse(
    val name: String,
    val detailProducts: List<DetailProductResponse>,
) {
    companion object {
        fun of(option: ProductOption): ProductOptionResponse {
            return ProductOptionResponse(
                name = option.name,
                detailProducts = option.detailProducts.map(DetailProductResponse::of)
            )
        }
    }
}