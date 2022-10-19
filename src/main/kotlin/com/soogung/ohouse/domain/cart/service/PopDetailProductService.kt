package com.soogung.ohouse.domain.cart.service

import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import com.soogung.ohouse.domain.cart.facade.CartFacade
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class PopDetailProductService(
    private val cartRepository: CartRepository,
    private val userFacade: UserFacade,
) {
    fun execute(id: Long) {
        cartRepository.deleteCartByUserAnAndDetailProduct(
            userFacade.getCurrentUser(), id
        )
    }

}