package com.soogung.ohouse.domain.cart.facade

import com.soogung.ohouse.domain.cart.domain.Cart
import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import com.soogung.ohouse.domain.cart.exception.CartNotFoundException
import com.soogung.ohouse.domain.product.domain.DetailProduct
import com.soogung.ohouse.domain.user.domain.User
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CartFacade(
    private val cartRepository: CartRepository,
) {
    @Transactional(readOnly = true)
    fun findCartById(id: Long): Cart {
        return cartRepository.findCartById(id)
            ?: throw CartNotFoundException.EXCEPTION
    }

    @Transactional(readOnly = true)
    fun findCartByUserAndDetailProduct(user: User, detailProduct: DetailProduct): Cart {
        return cartRepository.findCartByUserAndDetailProduct(user, detailProduct)
            ?: throw CartNotFoundException.EXCEPTION
    }
}