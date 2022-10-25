package com.soogung.ohouse.domain.cart.service

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import com.soogung.ohouse.domain.cart.presentation.dto.response.CartDetailProductResponse
import com.soogung.ohouse.domain.cart.presentation.dto.response.CartProductResponse
import com.soogung.ohouse.domain.cart.presentation.dto.response.CartResponse
import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.product.domain.Product
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.product.presentation.dto.response.DetailProductResponse
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductDeliveryResponse
import com.soogung.ohouse.domain.product.presentation.dto.response.ProductImageResponse
import com.soogung.ohouse.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class QueryCartService(
    private val cartRepository: CartRepository,
    private val userFacade: UserFacade,
) {
    fun execute(): CartResponse {
        val result = cartRepository.findCartByUser(userFacade.getCurrentUser())
            .groupBy { it.product }
            .map { (k, v) -> createCartProductResponse(k, setCartDetailProduct(v)) }

        return CartResponse(
            products = result
        )
    }

    private fun createCartProductResponse(product: Product, detailProducts: List<CartDetailProductResponse>): CartProductResponse {
        return CartProductResponse(
            id = product.id!!,
            name = product.name,
            image = ProductImageResponse.of(product.images[0]),
            deliveryResponse = ProductDeliveryResponse.of(product.delivery),
            detailProducts = detailProducts
        )
    }

    private fun setCartDetailProduct(products: List<Cart>): List<CartDetailProductResponse> {
        return products.map { CartDetailProductResponse(
            cartId = it.id!!,
            quantity = it.quantity,
            productName = it.detailProduct.name
        ) }
    }
}