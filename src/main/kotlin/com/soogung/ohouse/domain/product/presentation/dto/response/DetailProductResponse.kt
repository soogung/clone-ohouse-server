package com.soogung.ohouse.domain.product.presentation.dto.response

import com.soogung.ohouse.domain.product.domain.DetailProduct

data class DetailProductResponse(
    val id: Long,
    val name: String,
    val price: Int,
) {
    companion object {
        fun of(detailProduct: DetailProduct): DetailProductResponse {
            return DetailProductResponse(
                id = detailProduct.id!!,
                name = detailProduct.name,
                price = detailProduct.price,
            )
        }
    }
}
