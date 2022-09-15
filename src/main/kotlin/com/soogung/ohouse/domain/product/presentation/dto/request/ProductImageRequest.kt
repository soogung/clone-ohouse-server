package com.soogung.ohouse.domain.product.presentation.dto.request

import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.domain.ProductImage
import org.hibernate.validator.constraints.URL

data class ProductImageRequest(
    @field:URL
    val imageUri: String,
) {
    fun toEntity(product: Product): ProductImage {
        return ProductImage(
            imageUri = imageUri,
            product = product
        )
    }
}