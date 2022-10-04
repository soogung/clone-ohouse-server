package com.soogung.ohouse.domain.cart.service

import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class PopProductService(
    private val cartRepository: CartRepository,
    private val userFacade: UserFacade,
    private val productFacade: ProductFacade,
) {
    fun execute(id: Long) {
        cartRepository.deleteAll(
            cartRepository.findCartsByUserAndProduct(
                userFacade.getCurrentUser(), productFacade.findProductById(id)
            )
        )
    }
}