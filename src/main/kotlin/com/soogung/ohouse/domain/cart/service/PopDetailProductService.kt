package com.soogung.ohouse.domain.cart.service

import com.soogung.ohouse.domain.cart.domain.repository.CartRepository
import com.soogung.ohouse.domain.cart.facade.CartFacade
import com.soogung.ohouse.domain.product.facade.ProductFacade
import com.soogung.ohouse.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class PopDetailProductService(
    private val cartRepository: CartRepository,
    private val cartFacade: CartFacade,
    private val userFacade: UserFacade,
    private val productFacade: ProductFacade,
) {
    fun execute(id: Long) {
        cartRepository.delete(
            cartFacade.findCartByUserAndDetailProduct(
                userFacade.getCurrentUser(), productFacade.findDetailProductById(id)
            )
        )
    }

}