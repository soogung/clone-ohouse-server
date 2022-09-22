package com.soogung.ohouse.domain.product.presentation.dto.response

import com.soogung.ohouse.domain.product.domain.ProductImage

data class ProductImageResponse(
    val imageUri: String,
) {
    companion object {
        fun of(image: ProductImage): ProductImageResponse {
            return ProductImageResponse(
                imageUri = image.imageUri
            )
        }
    }
}