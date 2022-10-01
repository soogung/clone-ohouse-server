package com.soogung.ohouse.domain.cart.presentation.dto.request

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.user.domain.User

data class PutProductRequest(
    val detailProductId: Long,
    val quantity: Int,
) {
    fun toEntity(detailProduct: DetailProduct, user: User): Cart {
        return Cart(
            product = detailProduct.productOption.product,
            productOption = detailProduct.productOption,
            detailProduct = detailProduct,
            user = user,
            quantity = quantity
        )
    }
}