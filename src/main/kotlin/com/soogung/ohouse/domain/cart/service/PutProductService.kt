package com.soogung.ohouse.domain.cart.service

import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import com.soogung.ohouse.domain.cart.presentation.dto.request.PutProductRequest
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PutProductService(
    private val cartRepository: CartRepository,
    private val userFacade: UserFacade,
    private val productFacade: ProductFacade,
) {

    @Transactional
    fun execute(request: PutProductRequest) {
        val user = userFacade.getCurrentUser()
        val product = productFacade.findDetailProductById(request.detailProductId)

        val cart = cartRepository.findCartByUserAndDetailProduct(user, product)

        if (cart == null) {
            cartRepository.save(request.toEntity(product, user))
        } else {
            cartRepository.updateCartQuantityByUserAndDetailProduct(
                request.quantity, cart.id!!
            )
        }
    }
}